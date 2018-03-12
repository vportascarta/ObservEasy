package com.nivtech.observeasy.db;

import com.nivtech.observeasy.models.Problem;
import com.nivtech.observeasy.models.Progress;
import com.nivtech.observeasy.models.RecordableItem;
import com.nivtech.observeasy.models.Team;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;

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
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        statement.executeUpdate(Progress.getCreateSQLQuery());
        statement.executeUpdate(Team.getCreateSQLQuery());
        statement.executeUpdate(Problem.getCreateSQLQuery());
    }

    public void saveData(RecordableItem item) throws SQLException, NullPointerException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(5);  // set timeout to 5 sec.
        statement.executeUpdate(item.getSaveSQLQuery());
    }

    public void exportCSV() throws FileNotFoundException, SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        PrintWriter csvWriter = new PrintWriter(new File("export_" + System.currentTimeMillis() + ".csv"));

        //Progress export
        ResultSet rs = statement.executeQuery("SELECT * FROM Progress");

        while (rs.next()) {
            StringBuilder row = new StringBuilder("Déroulement;");
            row.append(rs.getLong(1));
            row.append(";").append(rs.getString(2).replaceAll("\"", "\\\""));
            row.append(";").append(rs.getString(3).replaceAll("\"", "\\\""));
            row.append(";").append(rs.getString(4).replaceAll("\"", "\\\""));

            csvWriter.println(row);
        }

        //Progress export
        rs = statement.executeQuery("SELECT * FROM Team");

        while (rs.next()) {
            StringBuilder row = new StringBuilder("Équipe;");
            row.append(rs.getLong(1));
            row.append(";").append(rs.getString(2).replaceAll("\"", "\\\""));
            row.append(";").append(rs.getInt(3));
            row.append(";").append(rs.getString(4).replaceAll("\"", "\\\""));

            csvWriter.println(row);
        }

        //Progress export
        rs = statement.executeQuery("SELECT * FROM Problem");

        while (rs.next()) {
            StringBuilder row = new StringBuilder("Problème;");
            row.append(rs.getLong(1));
            row.append(";").append(rs.getString(2).replaceAll("\"", "\\\""));
            row.append(";").append("Rien");
            row.append(";").append(rs.getString(3).replaceAll("\"", "\\\""));

            csvWriter.println(row);
        }

        csvWriter.close();
    }

    public void exportText() throws SQLException, FileNotFoundException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.

        PrintWriter csvWriter = new PrintWriter(new File("export_" + System.currentTimeMillis() + ".txt"));

        //Progress export
        ResultSet rs = statement.executeQuery("SELECT * FROM Progress");

        while (rs.next()) {
            StringBuilder row = new StringBuilder("Déroulement -> Temps : " + rs.getLong(1));
            row.append(" / Type : ").append(rs.getString(2).replaceAll("\"", "\\\""));
            row.append(" / Étape : ").append(rs.getString(3).replaceAll("\"", "\\\""));
            row.append(" / Note : ").append(rs.getString(4).replaceAll("\"", "\\\""));

            csvWriter.println(row);
        }

        //Progress export
        rs = statement.executeQuery("SELECT * FROM Team");

        while (rs.next()) {
            StringBuilder row = new StringBuilder("Équipe -> Temps : " + rs.getLong(1));
            row.append(" / Type : ").append(rs.getString(2).replaceAll("\"", "\\\""));
            row.append(" / Équipe : ").append(rs.getInt(3));
            row.append(" / Note : ").append(rs.getString(4).replaceAll("\"", "\\\""));

            csvWriter.println(row);
        }

        //Progress export
        rs = statement.executeQuery("SELECT * FROM Problem");

        while (rs.next()) {
            StringBuilder row = new StringBuilder("Problème -> Temps : " + rs.getLong(1));
            row.append(" / Type : ").append(rs.getString(2).replaceAll("\"", "\\\""));
            row.append(" / Note : ").append(rs.getString(3).replaceAll("\"", "\\\""));

            csvWriter.println(row);
        }

        csvWriter.close();
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
