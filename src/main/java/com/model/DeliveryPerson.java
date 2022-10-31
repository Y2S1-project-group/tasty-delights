package com.model;

public class DeliveryPerson extends Person{
    private String name;
    private int age;
    private String contact;
    private String email;

    public DeliveryPerson(int id, String name, int age, String contact, String email) {
        super(id);
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }

    public DeliveryPerson(int id, String name, int age, String contact, String email, String password) {
        super(id, password);
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
}
