package com.nivtech.observeasy.controllers;

import com.nivtech.observeasy.db.SQLiteLinker;
import com.nivtech.observeasy.views.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EraseController implements ActionListener {

    Window window;
    SQLiteLinker db;

    public EraseController(Window window, SQLiteLinker db) {
        this.window = window;
        this.db = db;
        window.getEraseButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tab_id = window.getTabs().getSelectedIndex();

        switch (tab_id) {
            case 0:
                window.getTabs().getProgressPanel().eraseFields();
                break;
            case 1:
                window.getTabs().getTeamPanel().eraseFields();
                break;
            case 2:
                window.getTabs().getProblemPanel().eraseFields();
                break;
        }
    }
}
