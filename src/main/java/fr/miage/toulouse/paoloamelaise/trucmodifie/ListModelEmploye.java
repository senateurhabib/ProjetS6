/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trucmodifie;

/**
 *
 * @author moi
 */

import components.Employe;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class ListModelEmploye implements ListModel<Employe> {
    private List<Employe> listeEmployes;
    private List<ListDataListener> listeners;

    public ListModelEmploye(List<Employe> listeEmployes) {
        this.listeEmployes = listeEmployes;
        this.listeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listeEmployes.size();
    }

    @Override
    public Employe getElementAt(int index) {
        return listeEmployes.get(index);
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

