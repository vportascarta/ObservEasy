package com.nivtech.observeasy.controllers;

import com.nivtech.observeasy.db.SQLiteLinker;
import com.nivtech.observeasy.views.Window;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowController implements WindowListener {

    Window window;
    SQLiteLinker db;

    public WindowController(Window window, SQLiteLinker db) {
        this.window = window;
        this.db = db;
        window.addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        db.close();
        window.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
