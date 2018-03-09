package com.nivtech.observeasy.models;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Problem extends RecordableItem {
    private static String SQLCreateQuery = "create table if not exists Problem (timestamp integer, type string, note string)";
    private static String SQLSaveFormat = "insert into Problem values(%d, %s, %s)";

    private LocalDateTime timestamp;
    private ProblemType type;
    private String note;

    public Problem() {
        timestamp = LocalDateTime.now();
        type = ProblemType.AUTRE;
        note = "";
    }

    public Problem(ProblemType type, String note) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.note = note;
    }

    @Override
    public String getSaveSQLQuery() {
        return String.format(SQLSaveFormat, timestamp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), type, note);
    }
}
