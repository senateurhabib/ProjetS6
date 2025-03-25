/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author moi
 */
package fr.miage.toulouse.paoloamelaise.components;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConnectionBd{
    private Connection connection;

    public ConnectionBd(String url, String username, String password) throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public ConnectionBd() throws SQLException, ClassNotFoundException {
        // Load Type-4 Driver
        // MySQL Type-4 driver class
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Database URL, username, and password

        // Replace with your database name
        String url = "jdbc:mysql://127.0.0.1:3306/db_proj";

        // Replace with your MySQL username
        String username = "pal";

        // Replace with your MySQL password
        String password = "jlupexgx";

        try {
            this.connection = DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
/*        catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
        }
*/
    }

    public Connection getC() {
        return this.connection;
    }

    public void ajouterMission(String description, Date dateDebut, int duree) throws SQLException {
        String query = "INSERT INTO Mission (idM, description, dateDebut, duree) VALUES (" + description + "," + new java.sql.Date(dateDebut.getTime()) + "," + duree + ");";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void modifierMission(int id, String nouvelleDescription, Date nouvelleDateDebut, int nouvelleDuree) throws SQLException {
        String query = "UPDATE Mission SET description=" + nouvelleDescription + ", dateDebut=" + new java.sql.Date(nouvelleDateDebut.getTime()) + ", duree=" + nouvelleDuree + " WHERE id=" + id + ";";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void afficherMissions() throws SQLException {
        String query = "SELECT * FROM Mission";
        ArrayList<String> missions = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                missions.add("ID: " + rs.getInt("idM") + ", Description: " + rs.getString("description") + ", Date Début: " + rs.getDate("dateDebut") + ", Durée: " + rs.getInt("duree"));
            }
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        for (String mission : missions) {
            System.out.println(mission);
        }
    }

    public void ajouterEmploye(String nouveauNom, String nouveauPrenom, String nouvelEmail) throws SQLException {
        String query = "INSERT INTO Employe (id, nom, prenom, email) VALUES (" + nouveauNom + "," + nouveauPrenom + "," + nouvelEmail + ");";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void modifierEmploye(int id, String nouveauNom, String nouveauPrenom, String nouvelEmail) throws SQLException {
        String query = "UPDATE Employe SET nom=" + nouveauNom + ", prenom=" + nouveauPrenom + ", email=" + nouvelEmail + " WHERE id=" + id + ";";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void afficherEmployes() throws SQLException {
        String query = "SELECT * FROM Employe";
        ArrayList<String> employes = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                employes.add("ID: " + rs.getInt("idP") + ", Prénom: " + rs.getString("prenom") + ", Nom: " + rs.getString("nom") + ", Date entrée dans l'entreprise: " + rs.getDate("dateEntree") + ", E-mail: " + rs.getString("email"));
            }
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        for (String employe : employes) {
            System.out.println(employe);
        }
    }

    public void ajouterCompetence(int id, String nouveauNom, String nouveauPrenom, String nouvelEmail) throws SQLException {
        String query = "INSERT INTO Competence (idC, nom, prenom, email) VALUES (" + id + "," + nouveauNom + "," + nouveauPrenom + "," + nouvelEmail + ");";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void afficherCompetences() throws SQLException {
        String query = "SELECT * FROM Competence";
        ArrayList<String> competences = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                competences.add("ID: " + rs.getInt("idC") + ", Nom en anglais: " + rs.getString("nomEn") + ", Nom en français: " + rs.getString("nomFr"));
            }
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        for (String competence : competences) {
            System.out.println(competence);
        }
    }
}

/*
    

    public void creerMission(int id, String description, Date dateDebut, int duree) throws SQLException {
        String query = "INSERT INTO Mission (id, description, dateDebut, duree) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, description);
            stmt.setDate(3, new java.sql.Date(dateDebut.getTime()));
            stmt.setInt(4, duree);
            stmt.executeUpdate();
        }
    }

    public void modifierMission(int id, String nouvelleDescription, Date nouvelleDateDebut, int nouvelleDuree) throws SQLException {
        String query = "UPDATE Mission SET description=?, dateDebut=?, duree=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, nouvelleDescription);
            stmt.setDate(2, new java.sql.Date(nouvelleDateDebut.getTime()));
            stmt.setInt(3, nouvelleDuree);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }
*/