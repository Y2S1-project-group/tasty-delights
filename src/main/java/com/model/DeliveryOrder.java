package com.model;

public class DeliveryOrder {
    private int id;
    private int orderId;
    private int deliveryPersonId;
    private String status;

    public DeliveryOrder(int orderId, int deliveryPersonId, String status) {
        this.orderId = orderId;
        this.deliveryPersonId = deliveryPersonId;
        this.status = status;
    }

    public DeliveryOrder(int id, int orderId, int deliveryPersonId, String status) {
        this.id = id;
        this.orderId = orderId;
        this.deliveryPersonId = deliveryPersonId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDeliveryPersonId(){ return deliveryPersonId; }

    public void setDeliveryPersonId(int deliveryPersonId){ this.deliveryPersonId = deliveryPersonId; }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
