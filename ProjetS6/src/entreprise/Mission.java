package entreprise;

import java.util.Date;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


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

    public void modifierMission(String nouvelleDescription, Date nouvelleDateDebut, int nouvelleDuree) {
        this.description = nouvelleDescription;
        this.dateDebut = nouvelleDateDebut;
        this.duree = nouvelleDuree;
    }

    public void participerMission(Technicien technicien) {
        participants.add(technicien);
        System.out.println(technicien.getNom() + " participe maintenant à la mission " + description);
    }
}



   