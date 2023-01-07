package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
    public static final String HOST = "jdbc:postgresql://snuffleupagus.db.elephantsql.com/";
    public static final String DATABASE = "bzifhkpr";
    public static final String USERNAME = "bzifhkpr";
    public static final String PASS = "0OgP0EmKAaylMJJmaNYRN7Wlp6WVpfMT";

    public Connection connection;

    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(HOST + DATABASE, USERNAME, PASS);
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void executeInsert(String sql) {
        try {
            Statement stm = this.connection.createStatement();
            stm.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
