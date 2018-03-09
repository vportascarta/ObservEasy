package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {

    public Menu () {
        super();
        buildSubMenus();
        this.setVisible(true);

    }

    public void buildSubMenus () {
        /** EXPORT **/
        JMenu exportMenu = new JMenu("Exporter");
        JMenuItem excelItem = new JMenuItem("Exporter en Excel");
        JMenuItem csvItem = new JMenuItem("Exporter en CSV");
        exportMenu.add(excelItem);
        exportMenu.add(csvItem);
        this.add(exportMenu);

        /** AIDE **/
        JMenu helpMenu = new JMenu("Aide");
        JMenuItem helpItem = new JMenuItem("Aide");
        JMenuItem aboutItem = new JMenuItem("A propos");
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        this.add(helpMenu);
    }
}
