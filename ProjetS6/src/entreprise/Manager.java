package entreprise;

class Manager extends Employee {
    public Manager(int id, String nom, String prenom, String email) {
        super(id, nom, prenom, email);
    }

    public void affecterMission(Mission mission, Technicien technicien) {
        mission.participerMission(technicien);
        System.out.println("Mission " + mission.getDescription() + " assignée à " + technicien.getNom());
    }
}
