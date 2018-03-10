package com.nivtech.observeasy.controllers;

import com.nivtech.observeasy.db.SQLiteLinker;
import com.nivtech.observeasy.views.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class TextExportController implements ActionListener {

    Window window;
    SQLiteLinker db;

    public TextExportController(Window window, SQLiteLinker db) {
        this.window = window;
        this.db = db;
        window.getMenu().getTextItem().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            db.exportText();
            window.getStatus().setMessage("Fichier texte exporté.");

        } catch (FileNotFoundException | SQLException e1) {
            window.getStatus().setMessage("Erreur lors de l'export !");
        }
    }
}
