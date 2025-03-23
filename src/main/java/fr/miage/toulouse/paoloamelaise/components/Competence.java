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

import java.util.List;
import java.util.ArrayList;

public class Competence {
    private String id;
    private String nom;
    private static List<Competence> listeCompetence = new ArrayList<>();

    public Competence(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    public String getId() {
        return this.id;
    }
    
    public static List<Competence> getListeCompetence() {
        return listeCompetence;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nom: " + this.nom;
    }   
}