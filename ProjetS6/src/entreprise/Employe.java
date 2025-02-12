package entreprise;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Employe {
    private int id;
    private String prenom;
    private String nom;
    private Date dateEntree;
    private String email;

    public Employe(int id, String prenom, String nom, Date dateEntree, String email) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.dateEntree = dateEntree;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void afficherEmploye() {
        System.out.println("ID: " + this.id + ", Prénom: " + this.prenom + ", Nom: " + this.nom + ", Date entrée dans l'entreprise: " + this.dateEntree + ", E-mail: " + this.email);
    }
    
    public void ajouterEmploye(int id, String nouveauNom, String nouveauPrenom, String nouvelEmail, Connection connection) throws SQLException {
        String query = "INSERT INTO Employe (id, nom, prenom, email) VALUES (" + this.id + "," + nouveauNom + "," + nouveauPrenom + "," + nouvelEmail + ");";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public void modifierEmploye(int id, String nouveauNom, String nouveauPrenom, String nouvelEmail, Connection connection) throws SQLException {
        String query = "UPDATE Employe SET nom=" + nouveauNom + ", prenom=" + nouveauPrenom + ", email=" + nouvelEmail + " WHERE id=" + this.id + ";";
        try (Statement st = connection.createStatement()) {
            int rows = st.executeUpdate(query);
            System.out.println(rows);
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    public static List<String> afficherEmployes(Connection connection) throws SQLException {
        String query = "SELECT * FROM Employe";
        List<String> employes = new ArrayList<>();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                employes.add("ID: " + rs.getInt("idP") + ", Prénom: " + rs.getString("prenom") + ", Nom: " + rs.getString("nom") + ", Date entrée dans l'entreprise: " + rs.getDate("dateEntree") + ", E-mail: " + rs.getString("email"));
            }
        }catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
        return employes;
    }
}