package org.example;

public class Main {
    public static void main(String[] args) {
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.connect();
        dbc.executeInsert("insert into person values " +
                "('twojstara','ts@twojstara.pl','1234',true,2)");
    }

}