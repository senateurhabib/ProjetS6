package entreprise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Competence {
    private int id;
    private String nom;

    public Competence(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public static List<String> afficherCompetences(Connection connection) throws SQLException {
        String query = "SELECT * FROM Competence";
        List<String> Competences = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Competences.add("ID: " + rs.getInt("idC") + ", Nom en anglais: " + rs.getString("nomEn") + ", Nom en français: " + rs.getString("nomFr"));
            }
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return Competences;
    }
}