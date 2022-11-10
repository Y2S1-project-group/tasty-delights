package com.model;

public class DeliveryPerson extends Person{
    private String name;
    private int age;
    private String contact;
    private String email;
    private String username;
    private String password;


    public DeliveryPerson(int id, String name, int age, String contact, String email, String username, String password) {
        super(id);
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public DeliveryPerson(int id, String password, String name, int age, String contact, String email, String username, String password1) {
        super(id);
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}

