package com.nivtech.observeasy.views;

import com.nivtech.observeasy.models.Problem;
import com.nivtech.observeasy.models.ProblemType;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ProblemPanel extends JComponent {

    private JComboBox<String> problemTypeBox;
    private JTextArea problemNote;

    public ProblemPanel() {
        super();
        problemTypeBox = buildProblemObservList();
        problemNote = new JTextArea(20, 40);

        build();
    }

    private void build() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel panelObservs = new JPanel();
        panelObservs.setLayout(new FlowLayout());
        panelObservs.add(new JLabel("Type d'observation : "));
        panelObservs.add(problemTypeBox);
        this.add(panelObservs);

        JPanel panelNotes = new JPanel(new FlowLayout());
        panelNotes.add(new JLabel("Notes : "));
        JTextArea textAreaNotes = problemNote;
        textAreaNotes.setLineWrap(true);
        textAreaNotes.setWrapStyleWord(true);
        panelNotes.add(textAreaNotes);
        this.add(panelNotes);

    }

    private JComboBox<String> buildProblemObservList() {
        String[] observs = Arrays.stream(ProblemType.class.getEnumConstants()).map(Enum::name).map(s -> s.replaceAll("_", " ")).toArray(String[]::new);
        JComboBox<String> observsList = new JComboBox<>(observs);

        observsList.setSelectedIndex(0);
        return observsList;
    }

    public void eraseFields() {
        problemNote.setText("");
    }

    public Problem getProblem() {
        return new Problem(ProblemType.values()[problemTypeBox.getSelectedIndex()], problemNote.getText().replaceAll("\n", " "));
    }
}
