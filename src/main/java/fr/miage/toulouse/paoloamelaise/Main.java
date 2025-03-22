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
        System.out.println(date);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);

        Employe emp = new Employe(12, "emp1", "emp2", "ampdk@dhdkh.com");
        Competence comp = new Competence(12, "comp1");
        System.out.println(comp);
        System.out.println(emp);

        Employe.getListeEmploye().add(emp);
        Employe.getListeEmploye().add(new Employe(1, "e", "ce", "c"));
        Employe.getListeEmploye().add(new Employe(3, "sz", "cse", "k"));
        Employe.getListeEmploye().add(new Employe(2, "kzk", "lj", "dze"));
        
        emp.competencesEmploye.add(comp);
        emp.competencesEmploye.add(new Competence(13, "cmp"));
        emp.competencesEmploye.add(new Competence(12, "comp1"));
        emp.competencesEmploye.add(new Competence(21, "arah"));
        emp.competencesEmploye.add(new Competence(45, "fr"));
        emp.competencesEmploye.add(new Competence(13, "zd"));
        emp.competencesEmploye.add(new Competence(12, "fe"));
        emp.competencesEmploye.add(new Competence(21, "arefeah"));
        emp.competencesEmploye.add(new Competence(45, "fvhh"));

        Mission mi = new Mission(23, "desc", new java.sql.Date(new Date().getTime()), 12);
        Mission.getListeMission().add(mi);
        
        mi.competencesRequises.add(comp);
        mi.participants.add(emp);
    }

    public void affecterMission(Mission mission, Employe employe) {
        mission.participerMission(employe);
        System.out.println("Mission " + mission.getDescription() + " assignée à " + employe.getNom());
    }
}

/*
for (Map.Entry<String, Personne> entry : personnes.entrySet()) {System.out.println(entry.getKey() + ": " + entry.getValue());}
*/