package com.nivtech.observeasy.models;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Team implements RecordableItem {
    private static String SQLCreateQuery = "create table if not exists team (timestamp integer, type string, id_team integer, note string)";
    private static String SQLSaveFormat = "insert into team values(%d, '%s', %d, '%s')";

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

    public Team(TeamType type, Integer id, String note) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.id_team = id;
        this.note = note;
    }

    public static String getCreateSQLQuery() {
        return SQLCreateQuery;
    }

    public String getSaveSQLQuery() {
        return String.format(SQLSaveFormat, timestamp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), type, id_team, note);
    }
}
