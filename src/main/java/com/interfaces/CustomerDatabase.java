package com.interfaces;

import com.model.Customer;

import java.util.ArrayList;

public interface CustomerDatabase {
    public boolean checkLogin(String email, String password);
    public boolean createCustomer(String fname, String lname, String age, String email, String contact, String address, String password);
    public String getCustomerFirstName(String email);
    public String getCustomerLastName(String email);
    public String getCustomerID(String email);
    public ArrayList<Customer> getCustomers();
}
