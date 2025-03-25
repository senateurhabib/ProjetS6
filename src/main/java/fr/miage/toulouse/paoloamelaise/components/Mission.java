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
import java.util.List;
import java.util.ArrayList;


public class Mission {
    private int id;
    private String description;
    private Date dateDebut;
    private int duree;
    private int nbParticipants;
    private List<Competence> competencesRequises;
    private List<Employe> participants;
    private static List<Mission> listeMission = new ArrayList<>();

    

    void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

}