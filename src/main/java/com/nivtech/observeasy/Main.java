package com.nivtech.observeasy;

import com.nivtech.observeasy.controllers.*;
import com.nivtech.observeasy.db.SQLiteLinker;
import com.nivtech.observeasy.views.Window;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Window window = new Window();

        SQLiteLinker db = new SQLiteLinker("data.db");

        window.getStatus().setMessage("Connexion à la base de donnée...");
        try {
            db.connect();
            window.getStatus().setMessage("Connexion établie.");
            window.getSaveButton().setEnabled(true);
        } catch (SQLException e) {
            db.close();
            window.getStatus().setMessage("Connexion échouée. Redémarrer l'application !");
        }

        new WindowController(window, db);
        new CSVExportController(window, db);
        new TextExportController(window, db);
        new SaveController(window, db);
        new EraseController(window, db);
        new NotificationController(window).startTimer();
    }
}
