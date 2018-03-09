package com.nivtech.observeasy.models;

import java.sql.Connection;
import java.time.LocalDateTime;

enum ProgressType {
    DEROULEMENT,
    ATTENTE,
    ANIMATION,
    EXPLICATIONS,
    DIRECTIVES,
    AUTRE
}

public class Progress implements Recordable {
    private LocalDateTime timestamp;
    private ProgressType type;
    private String step;
    private String note;

    public Progress() {
        timestamp = LocalDateTime.now();
        type = ProgressType.AUTRE;
        step = "";
        note = "";
    }

    public void saveToDatabase(Connection c) {

    }
}
