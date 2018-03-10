package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Window extends JFrame {

    private Menu menu;
    private TabbedPanes tabs;
    private StatusBar status;
    private JButton saveButton;
    private JButton eraseButton;


    public Window() {
        super();
        this.setTitle("ObservEasy");
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());
        this.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("icon.png"))).getImage());


        menu = new Menu();
        tabs = new TabbedPanes();
        status = new StatusBar(this.getWidth());
        saveButton = new JButton("Sauvegarder");
        eraseButton = new JButton("Effacer");

        this.init();
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
        this.setJMenuBar(menu);

        JPanel elem = new JPanel();
        elem.setLayout(new BorderLayout());
        elem.add(tabs, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2));
        buttons.add(saveButton);
        buttons.add(eraseButton);

        elem.add(buttons, BorderLayout.SOUTH);

        this.add(elem, BorderLayout.CENTER);
        this.add(status, BorderLayout.SOUTH);
        this.saveButton.setEnabled(false);

        this.setVisible(true);
    }
}
