package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {

    public Menu () {
        super();
        this.setVisible(true);
        buildSubMenus();
    }

    public void buildSubMenus () {
        JMenu fichier = new JMenu("Fichier");
    }
}
