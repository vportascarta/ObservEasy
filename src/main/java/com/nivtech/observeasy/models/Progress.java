package com.nivtech.observeasy.models;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Progress extends RecordableItem {
    private static String SQLCreateQuery = "create table if not exists Progress (timestamp integer, type string, step string, note string)";
    private static String SQLSaveFormat = "insert into Progress values(%d, %s, %s, %s)";

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

    public Progress(ProgressType type, String step, String note) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.step = step;
        this.note = note;
    }

    public String getSaveSQLQuery() {
        return String.format(SQLSaveFormat, timestamp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), type, step, note);
    }
}
