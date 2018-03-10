package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private Menu menu;
    private TabbedPanes tabs;
    private StatusBar status;
    private JButton saveButton;
    private JButton eraseButton;


    public Window() {
        super();
        menu = new Menu();
        tabs = new TabbedPanes();
        status = new StatusBar(this.getWidth());
        saveButton = new JButton("Sauvegarder");
        eraseButton = new JButton("Effacer");
    }

    public Menu getMenu() {
        return menu;
    }

    public TabbedPanes getTabs() {
        return tabs;
    }

    public StatusBar getStatus() {
        return status;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getEraseButton() {
        return eraseButton;
    }

    public void init() {
        this.setTitle("ObservEasy");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());

        this.setJMenuBar(menu);

        JPanel elem = new JPanel();
        elem.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        elem.add(tabs, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        elem.add(saveButton, c);

        c.gridx = 1;
        c.gridy = 1;
        elem.add(eraseButton, c);

        this.add(elem, BorderLayout.CENTER);
        this.add(status, BorderLayout.SOUTH);
        this.saveButton.setEnabled(false);

        this.setVisible(true);
    }
}
