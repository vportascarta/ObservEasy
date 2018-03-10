package com.nivtech.observeasy.views;

import com.nivtech.observeasy.models.Progress;
import com.nivtech.observeasy.models.ProgressType;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ProgressPanel extends JComponent {

    private JComboBox<String> progressTypeBox;
    private JTextField progressStepField;
    private JTextArea progressNote;

    public ProgressPanel() {
        super();

        progressTypeBox = this.buildObservsList();
        progressStepField = new JTextField(20);
        progressNote = new JTextArea(20, 40);

        build();
    }

    private void build() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel panelObservs = new JPanel(new FlowLayout());
        panelObservs.setLayout(new FlowLayout());
        panelObservs.add(new JLabel("Type d'observation : "));
        panelObservs.add(progressTypeBox);
        this.add(panelObservs);

        JPanel panelStep = new JPanel(new FlowLayout());
        panelStep.add(new JLabel("Étape en cours : "));
        panelStep.add(progressStepField);
        this.add(panelStep);

        JPanel panelNotes = new JPanel(new FlowLayout());
        panelNotes.add(new JLabel("Notes : "));
        progressNote.setLineWrap(true);
        progressNote.setWrapStyleWord(true);
        panelNotes.add(progressNote);
        this.add(panelNotes);

    }

    private JComboBox<String> buildObservsList() {
        String[] observs = Arrays.stream(ProgressType.class.getEnumConstants()).map(Enum::name).map(s -> s.replaceAll("_", " ")).toArray(String[]::new);
        JComboBox<String> observsList = new JComboBox<>(observs);

        observsList.setSelectedIndex(0);
        return observsList;
    }

    public void eraseFields() {
        progressNote.setText("");
    }

    public Progress getProgess() {
        return new Progress(ProgressType.values()[progressTypeBox.getSelectedIndex()], progressStepField.getText(), progressNote.getText().replaceAll("\n", " "));
    }
}
