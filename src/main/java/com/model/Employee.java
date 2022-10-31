package com.model;

public class Employee extends Person{
    private String username;

    public Employee(String username, String password){
        super(password);
        this.username = username;
    }
    public Employee(int id, String username, String password){
        super(id, password);
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
