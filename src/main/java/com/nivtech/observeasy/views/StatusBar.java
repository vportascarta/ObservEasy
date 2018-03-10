package com.nivtech.observeasy.views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class StatusBar extends JPanel {

    JLabel statusLabel;

    public StatusBar(int width) {
        super();

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel.setPreferredSize(new Dimension(width, 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));

        statusLabel = new JLabel("status");
        this.add(statusLabel);
    }

    public void setMessage(String message) {
        statusLabel.setText(" " + message);
    }
}
