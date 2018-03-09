package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.*;

public class ProblemPanel extends JComponent {
    private JPanel panelObservs;
    private JPanel panelNotes;
    private JPanel panelButtons;

    public ProblemPanel () {
        super();
        panelObservs = new JPanel(new FlowLayout());
        panelNotes = new JPanel(new FlowLayout());
        panelButtons = new JPanel(new FlowLayout());

        build();
    }

    private void build () {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        panelObservs.setLayout(new FlowLayout());
        panelObservs.add(new JLabel("Type d'observation : "));
        panelObservs.add(this.buildProblemObservList());
        this.add(panelObservs);

        panelNotes.add(new JLabel("Notes : "));
        JTextArea textAreaNotes = new JTextArea(20,40);
        textAreaNotes.setLineWrap(true);
        textAreaNotes.setWrapStyleWord(true);
        panelNotes.add(textAreaNotes);
        this.add(panelNotes);

        JButton saveButton = new JButton("Sauvegarder");
        JButton eraseButton = new JButton("Effacer");
        panelButtons.add(saveButton);
        panelButtons.add(eraseButton);
        this.add(panelButtons);
    }

    private JComboBox buildProblemObservList (){
        String[] observs = {"Problème technique", "Problème contenu", "Solution", "Autre"};
        JComboBox observsList = new JComboBox(observs);

        observsList.setSelectedIndex(1);
        return observsList;
    }
}
