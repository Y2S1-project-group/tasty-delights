package com.interfaces;

import java.util.ArrayList;

public interface DeliveryOrder {
    public boolean addOrderToDelivery(int did, int orderId);
    public ArrayList<DeliveryOrder> getDeliveryOrders();
}
