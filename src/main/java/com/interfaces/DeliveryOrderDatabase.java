package com.interfaces;

import com.model.DeliveryOrder;

import java.util.ArrayList;

public interface DeliveryOrderDatabase {
    public boolean addOrderToDelivery(int did, int orderId);
    public ArrayList<DeliveryOrder> getDeliveryOrders();
}
