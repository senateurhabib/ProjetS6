package entreprise;
class Employee {
    private int id;
    private String nom;
    private String prenom;
    private String email;

    public Employee(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
          }

    public String getNom() {
        return nom;
    }
}

	 



