package com.nivtech.observeasy.controllers;

import com.nivtech.observeasy.db.SQLiteLinker;
import com.nivtech.observeasy.models.RecordableItem;
import com.nivtech.observeasy.views.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SaveController implements ActionListener {

    Window window;
    SQLiteLinker db;

    public SaveController(Window window, SQLiteLinker db) {
        this.window = window;
        this.db = db;
        window.getSaveButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tab_id = window.getTabs().getSelectedIndex();

        RecordableItem item = null;
        switch (tab_id) {
            case 0:
                item = window.getTabs().getProgressPanel().getProgess();
                break;
            case 1:
                item = window.getTabs().getTeamPanel().getTeam();
                break;
            case 2:
                item = window.getTabs().getProblemPanel().getProblem();
                break;
        }

        try {
            db.saveData(item);
            window.getStatus().setMessage("Observation enregistrée " + tab_id);

        } catch (SQLException | NullPointerException e1) {
            window.getStatus().setMessage("Erreur lors de l'enregistrement !");
        }
    }
}
