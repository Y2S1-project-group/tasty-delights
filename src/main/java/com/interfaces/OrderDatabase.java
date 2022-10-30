package com.interfaces;

import com.model.Order;

import java.util.ArrayList;

public interface OrderDatabase {
    public ArrayList<Order> getOrders();
    public ArrayList<Order> getPendingOrders();
    public ArrayList<Order> getPreparingOrders();
    public ArrayList<Order> getDeliveringOrders();
    public ArrayList<Order> getCompletedOrders();
    public ArrayList<Order> getAnOrder(int orderID);
    public boolean updateAnOrder(int id, String name, int quantity, double price);
    public boolean deleteAnOrder(int id);
    public boolean updateOrderStatus(int id, String status);
}
