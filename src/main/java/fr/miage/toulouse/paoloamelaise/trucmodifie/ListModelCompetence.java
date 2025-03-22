/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trucmodifie;

/**
 *
 * @author moi
 */

import components.Competence;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class ListModelCompetence implements ListModel<Competence> {
    private List<Competence> listeCompetences;
    private List<ListDataListener> listeners;

    public ListModelCompetence(List<Competence> listeCompetences) {
        this.listeCompetences = listeCompetences;
        this.listeners = new ArrayList<>();
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
    public void addListDataListener(ListDataListener l) {
        listeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        listeners.remove(l);
    }
}

