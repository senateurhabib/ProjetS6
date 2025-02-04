package entreprise;
public class GestionMissionPersonnel {
    private Connection connection;

    public GestionMissionPersonnel(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
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

    public List<String> afficherMissions() throws SQLException {
        String query = "SELECT * FROM Mission";
        List<String> missions = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                missions.add("ID: " + rs.getInt("id") + ", Description: " + rs.getString("description") + ", Date Début: " + rs.getDate("dateDebut") + ", Durée: " + rs.getInt("duree"));
            }
        }
        return missions;
    }
}