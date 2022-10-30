package com.interfaces;

public interface CustomerDatabase {
    public boolean checkLogin(String email, String password);
    public boolean createCustomer(String fname, String lname, String age, String email, String contact, String address, String password);
}
