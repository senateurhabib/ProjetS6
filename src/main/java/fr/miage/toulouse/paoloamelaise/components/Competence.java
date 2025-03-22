/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author moi
 */
package fr.miage.toulouse.paoloamelaise.components;

import java.util.List;

public class Competence {

    private int id;
    private String nom;

    public Competence(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + ", Nom: " + this.nom;
    }   
}
