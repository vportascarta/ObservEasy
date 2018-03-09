package com.nivtech.observeasy.models;

import java.sql.Connection;

public interface Recordable {
    void saveToDatabase(Connection c);
}
