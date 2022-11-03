package com.model;

public class Order {
    private int id;
    private int cusid;
    private String name;
    private int quantity;
    private String status;
    private double tprice;
    private String orderedtime;

    public Order(int id, int cusid, String name, int quantity, String status, double tprice, String orderedtime) {
        this.id = id;
        this.cusid = cusid;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.tprice = tprice;
        this.orderedtime = orderedtime;
    }

    public String getOrderedtime() {
        return orderedtime;
    }

    public void setOrderedtime(String orderedtime) {
        this.orderedtime = orderedtime;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuality() {
        return quantity;
    }

    public void setQuality(int quality) {
        this.quantity = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
