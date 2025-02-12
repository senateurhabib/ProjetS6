package entreprise;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Mission {
    private int id;
    private String description;
    private Date dateDebut;
    private int duree;
    private List<Competence> competencesRequises;
    private List<Technicien> participants;

    public Mission(int id, String description, Date dateDebut, int duree, List<Competence> competencesRequises) {
        this.id = id;
        this.description = description;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.competencesRequises = competencesRequises;
        this.participants = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public void afficherMission() {
        System.out.println("ID: " + id + ", Description: " + description + ", Date Début: " + dateDebut + ", Durée: " + duree);
    }

    public void ajouterMission(int id, String description, Date dateDebut, int duree, Connection connection) throws SQLException {
        String query = "INSERT INTO Mission (id, description, dateDebut, duree) VALUES (" + id + "," + description + "," + new java.sql.Date(dateDebut.getTime()) + "," + duree + ");";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void modifierMission(String nouvelleDescription, Date nouvelleDateDebut, int nouvelleDuree, Connection connection) throws SQLException {
        String query = "UPDATE Employe SET description=" + nouvelleDescription + ", dateDebut=" + new java.sql.Date(nouvelleDateDebut.getTime()) + ", duree=" + nouvelleDuree + " WHERE id=" + this.id + ";";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void participerMission(Technicien technicien) {
        participants.add(technicien);
        System.out.println(technicien.getNom() + " participe maintenant à la mission " + description);
    }
}

/*
    public static List<String> afficherMissions(Connection connection) throws SQLException {
        String query = "SELECT * FROM Mission";
        List<String> missions = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                missions.add("ID: " + rs.getInt("id") + ", Description: " + rs.getString("description") + ", Date Début: " + rs.getDate("dateDebut") + ", Durée: " + rs.getInt("duree"));
            }
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return missions;
    }

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