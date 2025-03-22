/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.miage.toulouse.paoloamelaise.trucmodifie;

/**
 *
 * @author moi
 */

import fr.miage.toulouse.paoloamelaise.components.Mission;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

public class ListModelMission implements ListModel<Mission> {
    private List<Mission> listeMission;
    private List<ListDataListener> listeners;

    public ListModelMission(List<Mission> listeMission) {
        this.listeMission = listeMission;
        this.listeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return listeMission.size();
    }

    @Override
    public Mission getElementAt(int index) {
        return listeMission.get(index);
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

