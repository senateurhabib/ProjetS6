package entreprise;

import java.sql.*;

class Manager extends Employe {
    public Manager(int id, String prenom, String nom, Date dateEntree, String email) {
        super(id, prenom, nom, dateEntree, email);
    }

    public void affecterMission(Mission mission, Technicien technicien) {
        mission.participerMission(technicien);
        System.out.println("Mission " + mission.getDescription() + " assignée à " + technicien.getNom());
    }
}
