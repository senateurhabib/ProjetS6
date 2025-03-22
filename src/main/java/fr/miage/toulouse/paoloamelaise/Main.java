/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author moi
 */

package fr.miage.toulouse.paoloamelaise;

import java.sql.SQLException;
import fr.miage.toulouse.paoloamelaise.auth.Login;
import fr.miage.toulouse.paoloamelaise.components.Competence;
import fr.miage.toulouse.paoloamelaise.components.Employe;
import fr.miage.toulouse.paoloamelaise.components.Mission;
import java.util.Date;
import fr.miage.toulouse.paoloamelaise.components.ConnectionBd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // At first, show the login page and show menu after - 
        // the authentication process completed

        Login log = new Login();
        log.setVisible(true);

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        Employe emp = new Employe(12, "emp1", "emp2", new java.sql.Date(new Date().getTime()), "ampdk@dhdkh.com");
        Competence comp = new Competence("12", "comp1");
        Mission mi = new Mission(23, "desc", new java.sql.Date(new Date().getTime()), 12);
        
        /*
        Competence.getListeCompetence().add(comp);
        Competence.getListeCompetence().add((new Competence("13", "zea")));
        Competence.getListeCompetence().add(new Competence("12", "efgg"));
        Competence.getListeCompetence().add(new Competence("21", "adfe"));
        
        Employe.getListeEmploye().add(emp);
        Employe.getListeEmploye().add(new Employe(1, "e", "ce", new java.sql.Date(new Date().getTime()), "c"));
        Employe.getListeEmploye().add(new Employe(3, "sz", "cse", new java.sql.Date(new Date().getTime()), "k"));
        Employe.getListeEmploye().add(new Employe(2, "kzk", "lj", new java.sql.Date(new Date().getTime()), "dze"));
        */
        
        Mission.getListeMission().add(mi);
        Mission.getListeMission().add(new Mission(13, "adda", new java.sql.Date(new Date().getTime()), 23));
        Mission.getListeMission().add(new Mission(3, "azdfdff", new java.sql.Date(new Date().getTime()), 2));
        Mission.getListeMission().add(new Mission(33, "ezv", new java.sql.Date(new Date().getTime()), 1));
        
        /*
        emp.getListeCompetences().add(comp);
        emp.getListeCompetences().add(new Competence("13", "cmp"));
        emp.getListeCompetences().add(new Competence("12", "comp1"));
        emp.getListeCompetences().add(new Competence("21", "arah"));
        emp.getListeCompetences().add(new Competence("45", "fr"));
        emp.getListeCompetences().add(new Competence("13", "zd"));
        emp.getListeCompetences().add(new Competence("12", "fe"));
        emp.getListeCompetences().add(new Competence("21", "arefeah"));
        emp.getListeCompetences().add(new Competence("45", "fvhh"));
        */

        mi.getListeCompetences().add(comp);
        mi.getListeCompetences().add(new Competence("13", "zd"));
        mi.getListeCompetences().add(new Competence("12", "fe"));
        mi.getListeCompetences().add(new Competence("21", "arefeah"));
        mi.getListeCompetences().add(new Competence("45", "fvhh"));
        
        mi.getListeEmploye().add(emp);
        
        System.out.println(date);
        System.out.println(sqlDate);
        System.out.println(comp);
        System.out.println(emp);
        System.out.println(mi);
        System.out.println("ok");
        
        
        Connection co = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_proj", "pal", "jlupexgx");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
        
        try (Statement stmt = co.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Personnel");
            while (rs.next()) {
                Employe.getListeEmploye().add(new Employe(rs.getInt("idP"), rs.getString("prenom"), rs.getString("nom"), rs.getDate("dateEntree"), rs.getString("email")));
            }
            
            rs = stmt.executeQuery("SELECT * FROM Competence");
            while (rs.next()) {
                Competence.getListeCompetence().add(new Competence(rs.getString("idC"), rs.getString("nomFr")));
            }
            
            rs = stmt.executeQuery("SELECT * FROM CompetencePersonnel");
            while (rs.next()) {
                Employe employeChoisi = emp;
                Competence competenceChoisie = comp;
                
                for (Employe e : Employe.getListeEmploye()) {
                    System.out.println("id:" + e.getId() + " " + rs.getInt("idP"));
                    if (rs.getInt("idP") == (e.getId())) {
                        employeChoisi = e;
                        break;
                    }
                }
                for (Competence c : Competence.getListeCompetence()) {
                    System.out.println("id:" + c.getId() + " " + rs.getString("idC"));
                    if (rs.getString("idC").equals(c.getId())) {
                        competenceChoisie = c;
                        System.out.println("true");
                        break;
                    }
                }
                
                System.out.println(employeChoisi);
                System.out.println(competenceChoisie);
                employeChoisi.getListeCompetences().add(competenceChoisie);
            }
        }catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
        
        System.out.println("Liste employes");
        for (Employe employe : Employe.getListeEmploye()) {
            System.out.println(employe);
        }
        
        System.out.println("Liste competences");
        for (Competence competence : Competence.getListeCompetence()) {
            System.out.println(competence);
        }
        
        System.out.println("Liste competences des employes");
        for (Employe employe : Employe.getListeEmploye()) {
            System.out.println(employe.getListeCompetences());
        }
    }

    public void affecterMission(Mission mission, Employe employe) {
        mission.participerMission(employe);
        System.out.println("Mission " + mission.getDescription() + " assignée à " + employe.getNom());
    }
}

/*
for (Map.Entry<String, Personne> entry : personnes.entrySet()) {System.out.println(entry.getKey() + ": " + entry.getValue());}
*/