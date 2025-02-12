package entreprise;

import java.sql.*;

class Technicien extends Employe {
    public Technicien(int id, String prenom, String nom, Date dateEntree, String email) {
        super(id, prenom, nom, dateEntree, email);
    }
}