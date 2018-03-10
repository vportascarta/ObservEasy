package com.nivtech.observeasy.controllers;

import com.nivtech.observeasy.views.Window;

import javax.swing.*;

public class NotificationController {

    private static final int DELAY = 5 * 60 * 1000;

    private Window window;
    private Timer timer;

    public NotificationController(Window window) {
        this.window = window;
        this.timer = new Timer(DELAY, e -> {
            JOptionPane.showMessageDialog(window, "Temps écoulé !", "Notification",
                    JOptionPane.INFORMATION_MESSAGE);
            this.startTimer();
        });
        this.timer.setRepeats(false);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

}
