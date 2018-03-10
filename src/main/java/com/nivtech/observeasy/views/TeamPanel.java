package com.nivtech.observeasy.views;

import com.nivtech.observeasy.models.Team;
import com.nivtech.observeasy.models.TeamType;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TeamPanel extends JComponent {
    private JComboBox<String> teamTypeBox;
    private JSpinner teamIdField;
    private JTextArea teamNote;

    public TeamPanel() {
        super();

        teamTypeBox = this.buildTeamObservList();
        SpinnerNumberModel numberSpinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
        teamIdField = new JSpinner(numberSpinnerModel);
        teamNote = new JTextArea(20, 40);


        build();
    }

    private void build() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel panelObservs = new JPanel(new FlowLayout());
        panelObservs.setLayout(new FlowLayout());
        panelObservs.add(new JLabel("Type d'observation : "));
        panelObservs.add(teamTypeBox);
        this.add(panelObservs);

        JPanel panelTeamNumber = new JPanel(new FlowLayout());
        panelTeamNumber.add(new JLabel("Numéro d'équipe"));
        panelTeamNumber.add(teamIdField);
        this.add(panelTeamNumber);

        JPanel panelNotes = new JPanel(new FlowLayout());
        panelNotes.add(new JLabel("Notes : "));
        teamNote.setLineWrap(true);
        teamNote.setWrapStyleWord(true);
        panelNotes.add(teamNote);
        this.add(panelNotes);

    }

    private JComboBox<String> buildTeamObservList() {
        String[] observs = Arrays.stream(TeamType.class.getEnumConstants()).map(Enum::name).map(s -> s.replaceAll("_", " ")).toArray(String[]::new);
        JComboBox<String> observsList = new JComboBox<>(observs);

        observsList.setSelectedIndex(0);
        return observsList;
    }

    public void eraseFields() {
        teamNote.setText("");
    }

    public Team getTeam() {
        return new Team(TeamType.values()[teamTypeBox.getSelectedIndex()], (Integer) teamIdField.getValue(), teamNote.getText().replaceAll("\n", " "));
    }
}
