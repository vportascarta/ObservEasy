package com.nivtech.observeasy.models;

public abstract class RecordableItem {
    private static String SQLCreateQuery;

    public static String getCreateSQLQuery() {
        return SQLCreateQuery;
    }

    abstract public String getSaveSQLQuery();
}
