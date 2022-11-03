package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection{
    private Connection con;
    private String dbDriver;
    private String url;
    private String database;
    private String username;
    private String password;

    private static DatabaseConnection db;

    private DatabaseConnection() throws Exception {
        this.dbDriver = "com.mysql.cj.jdbc.Driver";
        this.url = "jdbc:mysql://127.0.0.1:3306/";
        this.database = "tasty_delights";
        this.username = "root";
        this.password = "root";

        Class.forName(this.dbDriver);
        this.con = DriverManager.getConnection(this.url + this.database, this.username, this.password);
    }

    public static DatabaseConnection getInstance() throws Exception {
        if(db == null) {
            db = new DatabaseConnection();
        }
        return db;
    }

    public Connection getConnection() {
        return con;
    }
}
