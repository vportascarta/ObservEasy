package com.nivtech.observeasy;

import com.nivtech.observeasy.db.SQLiteLinker;
import com.nivtech.observeasy.models.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        System.out.println("Test-Application : Observ'Easy");
        SQLiteLinker db = new SQLiteLinker("data.db");

        System.out.println("Connect to database");

        try {
            db.connect();
        } catch (SQLException e) {
            e.printStackTrace();
            db.close();
            System.exit(-1);
        }

        System.out.println("Database OK");

        String input;
        Scanner stdin = new Scanner(System.in);

        do {
            System.out.println("Choose a category : 1=Progress, 2=Team, 3=Problem or type 'E' to export to CSV");
            input = stdin.next();

            RecordableItem item;

            switch (input) {
                case "1":
                    item = new Progress(ProgressType.ANIMATION, "toto", "titi");
                    break;
                case "2":
                    item = new Team();
                    break;
                case "3":
                    item = new Problem();
                    break;
                case "e":
                case "E":
                    item = null;
                    try {
                        db.exportCSV();
                    } catch (FileNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("File Saved !");
                    break;
                default:
                    item = null;
                    System.out.println("ERROR please retry !");
                    break;
            }

            try {
                if (item != null)
                    db.saveData(item);
            } catch (SQLException e) {
                e.printStackTrace();
                db.close();
                System.exit(-2);
            }

            System.out.println("'C' to continue or 'Q' to Quit");
            input = stdin.next();
        } while (!input.equals("q") && !input.equals("Q"));
    }
}
