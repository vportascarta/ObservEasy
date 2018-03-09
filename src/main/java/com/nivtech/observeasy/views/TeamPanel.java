package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.*;

public class TeamPanel extends JComponent {
    private JPanel panelObservs;
    private JPanel panelTeamNumber;
    private JPanel panelNotes;
    private JPanel panelButtons;

    public TeamPanel () {
        super();
        panelObservs = new JPanel(new FlowLayout());
        panelTeamNumber = new JPanel(new FlowLayout());
        panelNotes = new JPanel(new FlowLayout());
        panelButtons = new JPanel(new FlowLayout());

        build();
    }

    private void build () {


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        panelObservs.setLayout(new FlowLayout());
        panelObservs.add(new JLabel("Type d'observation : "));
        panelObservs.add(this.buildTeamObservList());
        this.add(panelObservs);

        panelTeamNumber.add(new JLabel("Numéro d'équipe"));
        SpinnerNumberModel numberSpinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner teamNumberSpinner = new JSpinner(numberSpinnerModel);
        panelTeamNumber.add(teamNumberSpinner);
        this.add(panelTeamNumber);


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

    private JComboBox buildTeamObservList() {
        String[] observs = {"Engagement", "Travail", "Autre"};
        JComboBox observsList = new JComboBox(observs);

        observsList.setSelectedIndex(1);
        return observsList;
    }
}
