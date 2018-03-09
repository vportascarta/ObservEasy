package com.nivtech.observeasy.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class TabbedPanes extends JTabbedPane {
    public TabbedPanes() {
        super();
        buildPanes();

    }

    public void buildPanes() {

        JComponent processPanel = new ProcessPanel();
        this.addTab("Déroulement", null, processPanel,
                "Observation du déroulement");
        this.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent teamPanel = new TeamPanel();
        this.addTab("Équipe", null, teamPanel,
                "Observation d'équipes");
        this.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent problemPanel = new ProblemPanel();
        this.addTab("Problème", null, problemPanel,
                "Problèmes rencontrés");
        this.setMnemonicAt(2, KeyEvent.VK_3);
    }


}
