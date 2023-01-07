package org.example;

public class Person {
    Long id;
    String username;
    String email;
    String pass;
    Boolean enabled;

    public Person(Long id, String username, String email, String pass, Boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.enabled = enabled;
    }

    public void save(DatabaseConnector dbc) {
        String insert = "insert into person values (" +
                "'" + this.username + "'," +
                "'" + this.email + "'," +
                "'" + this.pass + "'," +
                this.enabled + "," +
                this.id;
        dbc.executeInsert(insert);
    }
}
