package com.model;

public class Person {
    protected int id;
    protected String password;

    Person(){
        this.id = 0;
        this.password = null;
    }
    Person(int id){
        this.id = id;
    }

    Person(String password){
        this.password = password;
    }

    Person(int id, String password){
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
