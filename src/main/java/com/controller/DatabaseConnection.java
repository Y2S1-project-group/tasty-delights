package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection{
    private Connection con;
    private final String dbDriver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://127.0.0.1:3306/";
    private final String database = "tasty_delights";
    private final String username = "root";
    private final String password = "1002";



    private static DatabaseConnection db;

    private DatabaseConnection() throws Exception {
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
