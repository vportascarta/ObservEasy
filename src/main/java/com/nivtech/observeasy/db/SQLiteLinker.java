package com.nivtech.observeasy.db;

import com.nivtech.observeasy.models.Problem;
import com.nivtech.observeasy.models.Progress;
import com.nivtech.observeasy.models.RecordableItem;
import com.nivtech.observeasy.models.Team;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteLinker {
    private String filename;
    private Connection connection;

    public SQLiteLinker(String filename) {
        this.filename = filename;
        this.connection = null;
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + filename);

        Statement statement = connection.createStatement();
        statement.setQueryTimeout(5);  // set timeout to 5 sec.

        statement.executeUpdate(Progress.getCreateSQLQuery());
        statement.executeUpdate(Team.getCreateSQLQuery());
        statement.executeUpdate(Problem.getCreateSQLQuery());
    }

    public void saveData(RecordableItem item) throws SQLException, NullPointerException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(5);  // set timeout to 5 sec.

        statement.executeUpdate(item.getSaveSQLQuery());
    }

    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            // connection close failed.
            System.err.println(e.toString());
        }
    }
}
