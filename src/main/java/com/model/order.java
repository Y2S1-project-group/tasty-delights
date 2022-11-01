package com.model;

public class order {
    int id;
    int cusid;
    String name;
    String quantity;
    String status;
    float price;
    String orderedtime;

    public order(int id, int cusid, String name, String quantity, String status, float price, String orderedtime) {
        this.id = id;
        this.cusid = cusid;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.price = price;
        this.orderedtime = orderedtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrderedtime() {
        return orderedtime;
    }

    public void setOrderedtime(String orderedtime) {
        this.orderedtime = orderedtime;
    }


}
