package entreprise;

import java.util.Date;

import java.util.List;


public class Mission {

    private int id;

    private String description;

    private Date dateDebut;

    private int duree;

    private List<Competence> competencesRequises;


    public Mission(int id, String description, Date dateDebut, int duree, List<Competence> competencesRequises) {

        this.id = id;

        this.description = description;

        this.dateDebut = dateDebut;

        this.duree = duree;

        this.competencesRequises = competencesRequises;

    }


    public int getId() {

        return id;

    }


    public void setId(int id) {

        this.id = id;

    }


    public String getDescription() {

        return description;

    }


    public void setDescription(String description) {

        this.description = description;

    }


    public Date getDateDebut() {

        return dateDebut;

    }


    public void setDateDebut(Date dateDebut) {

        this.dateDebut = dateDebut;

    }


    public int getDuree() {

        return duree;

    }


    public void setDuree(int duree) {

        this.duree = duree;

    }


    public List<Competence> getCompetencesRequises() {

        return competencesRequises;

    }


    public void setCompetencesRequises(List<Competence> competencesRequises) {

        this.competencesRequises = competencesRequises;

    }

}



   