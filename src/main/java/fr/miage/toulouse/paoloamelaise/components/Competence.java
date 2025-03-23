/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author moi
 */
package fr.miage.toulouse.paoloamelaise.components;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Mission {
    private int id;
    private String description;
    private Date dateDebut;
    private int duree;
    private int nbParticipants;
    private List<Competence> competencesRequises;
    private List<Employe> participants;
    private static List<Mission> listeMission = new ArrayList<>();

    public Mission(int id, String description, Date dateDebut, int duree) {
        this.id = id;
        this.description = description;
        this.dateDebut = dateDebut;
        this.duree = duree;
        this.competencesRequises = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public void participerMission(Employe employe) {
        participants.add(employe);
        System.out.println(employe.getNom() + " participe maintenant à la mission " + description);
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return dateDebut;
    }

    public int getDuree() {
        return duree;
    }
    
    public List<Competence> getListeCompetences() {
        return competencesRequises;
    }
    
    public static List<Mission> getListeMission() {
        return listeMission;
    }

    public List<Employe> getListeEmploye() {
        return participants;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.dateDebut = date;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description + ", Date Début: " + dateDebut + ", Durée: " + duree;
    }

    void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

}