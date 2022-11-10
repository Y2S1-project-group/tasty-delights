package com.model;

public class Customer {
    private int id;
    private String fname;
    private String lname;
    private String password;
    private String email;
    private String contact;
    private String address;

    public Customer(int id, String fname, String lname, String email, String contact, String address) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }
    public Customer(int id, String fname, String lname, String password, String email, String contact, String address) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
