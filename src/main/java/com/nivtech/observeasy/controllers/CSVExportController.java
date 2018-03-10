package com.nivtech.observeasy.controllers;

import com.nivtech.observeasy.db.SQLiteLinker;
import com.nivtech.observeasy.views.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class CSVExportController implements ActionListener {

    Window window;
    SQLiteLinker db;

    public CSVExportController(Window window, SQLiteLinker db) {
        this.window = window;
        this.db = db;
        window.getMenu().getCsvItem().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            db.exportCSV();
            window.getStatus().setMessage("Fichier CSV exporté.");

        } catch (FileNotFoundException | SQLException e1) {
            window.getStatus().setMessage("Erreur lors de l'export !");
        }
    }
}
