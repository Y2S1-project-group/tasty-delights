package com.interfaces;

public interface CustomerDatabase {
    public boolean checkLogin(String email, String password);
    public boolean createCustomer(String fname, String lname, String age, String email, String contact, String address, String password);
    public String getCustomerFirstName(String email);
    public String getCustomerLastName(String email);
    public String getCustomerID(String email);
}
