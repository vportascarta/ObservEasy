package com.nivtech.observeasy.views;

import javax.swing.*;

public class Menu extends JMenuBar {

    private JMenu exportMenu;
    private JMenuItem csvItem;
    private JMenuItem textItem;
    private JMenu helpMenu;
    private JMenuItem helpItem;
    private JMenuItem aboutItem;

    public Menu() {
        super();
        buildSubMenus();
        this.setVisible(true);
    }

    public JMenuItem getCsvItem() {
        return csvItem;
    }

    public JMenuItem getTextItem() {
        return textItem;
    }

    public JMenuItem getHelpItem() {
        return helpItem;
    }

    public JMenuItem getAboutItem() {
        return aboutItem;
    }

    public void buildSubMenus() {
        /** EXPORT **/
        exportMenu = new JMenu("Exporter");
        csvItem = new JMenuItem("Exporter en CSV");
        textItem = new JMenuItem("Exporter en texte");
        exportMenu.add(csvItem);
        exportMenu.add(textItem);
        this.add(exportMenu);

        /** AIDE **/
        helpMenu = new JMenu("Aide");
        helpItem = new JMenuItem("Aide");
        aboutItem = new JMenuItem("A propos");
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        this.add(helpMenu);
    }
}
