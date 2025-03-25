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
    
    
    @Override
    public String toString() {
        return "ID: " + this.id + ", Prénom: " + this.prenom + ", Nom: " + this.nom + /*", Date entrée dans l'entreprise: " + this.dateEntree*/  ", E-mail: " + this.email;
    }
}
