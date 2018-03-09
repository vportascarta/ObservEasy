package com.nivtech.observeasy.models;

import java.sql.Connection;
import java.time.LocalDateTime;

enum ProblemType {
    PROBLEME_TECHNIQUE,
    PROBLEME_CONTENU,
    SOLUTION,
    AUTRE
}

public class Problem implements Recordable {
    private LocalDateTime timestamp;
    private ProblemType type;
    private String note;

    public Problem() {
        timestamp = LocalDateTime.now();
        type = ProblemType.AUTRE;
        note = "";
    }

    @Override
    public void saveToDatabase(Connection c) {

    }
}
