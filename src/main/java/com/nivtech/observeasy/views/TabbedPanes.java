package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TabbedPanes extends JTabbedPane {

    private ProgressPanel progressPanel;
    private TeamPanel teamPanel;
    private ProblemPanel problemPanel;

    public TabbedPanes() {
        super();

        progressPanel = new ProgressPanel();
        teamPanel = new TeamPanel();
        problemPanel = new ProblemPanel();

        buildPanes();
    }

    public ProgressPanel getProgressPanel() {
        return progressPanel;
    }

    public TeamPanel getTeamPanel() {
        return teamPanel;
    }

    public ProblemPanel getProblemPanel() {
        return problemPanel;
    }

    public void buildPanes() {

        this.addTab("Déroulement", null, progressPanel,
                "Observation du déroulement");
        this.setMnemonicAt(0, KeyEvent.VK_1);

        this.addTab("Équipe", null, teamPanel,
                "Observation d'équipes");
        this.setMnemonicAt(1, KeyEvent.VK_2);

        this.addTab("Problème", null, problemPanel,
                "Problèmes rencontrés");
        this.setMnemonicAt(2, KeyEvent.VK_3);
    }

}
