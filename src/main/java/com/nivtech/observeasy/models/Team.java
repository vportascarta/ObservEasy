package com.nivtech.observeasy.models;

import java.sql.Connection;
import java.time.LocalDateTime;

enum TeamType {
    ENGAGEMENT,
    TRAVAIL,
    AUTRE
}

public class Team implements Recordable {
    private LocalDateTime timestamp;
    private TeamType type;
    private Integer id_team;
    private String note;

    public Team() {
        timestamp = LocalDateTime.now();
        type = TeamType.AUTRE;
        id_team = 0;
        note = "";
    }

    public void saveToDatabase(Connection c) {

    }
}
