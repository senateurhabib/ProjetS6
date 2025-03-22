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

public class Employe {
    private int id;
    private String prenom;
    private String nom;
    private Date dateEntree;
    private String email;
    private List<Competence> competencesEmploye;
    public static List<Employe> listeEmployes = new ArrayList<>();
    
    public Employe(int id, String prenom, String nom, Date dateEntree, String email) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.dateEntree = dateEntree;
        this.email = email;
        this.competencesEmploye = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }
    
    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public static List<Employe> getListeEmploye() {
        return listeEmployes;
    }
    
    public List<Competence> getListeCompetences() {
        return competencesEmploye;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Prénom: " + this.prenom + ", Nom: " + this.nom + /*", Date entrée dans l'entreprise: " + this.dateEntree*/  ", E-mail: " + this.email;
    }
}
