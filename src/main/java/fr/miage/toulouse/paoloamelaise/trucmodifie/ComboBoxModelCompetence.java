/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.miage.toulouse.paoloamelaise.trucmodifie;

import fr.miage.toulouse.paoloamelaise.components.Competence;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author moi
 */
public class ComboBoxModelCompetence extends AbstractListModel implements ComboBoxModel {
    private List<Competence> listeCompetences;
    private Object selection = null;
    
    public ComboBoxModelCompetence(List<Competence> listeCompetences) {
        this.listeCompetences = listeCompetences;
    }

    @Override
    public int getSize() {
        return listeCompetences.size();
    }

    @Override
    public Competence getElementAt(int index) {
        return listeCompetences.get(index);
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        selection = anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selection;
    }
}