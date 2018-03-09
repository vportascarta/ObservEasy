package com.nivtech.observeasy.models;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Problem implements RecordableItem {
    private static String SQLCreateQuery = "create table if not exists problem (timestamp integer, type string, note string)";
    private static String SQLSaveFormat = "insert into problem values(%d, '%s', '%s')";

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

    public static String getCreateSQLQuery() {
        return SQLCreateQuery;
    }

    @Override
    public String getSaveSQLQuery() {
        return String.format(SQLSaveFormat, timestamp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), type, note);
    }
}
