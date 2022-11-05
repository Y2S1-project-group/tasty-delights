package com.model;

public class Order {
    private int id;
    private int cusid;
    private String status;
    private float tprice;
    private String orderedtime;

    public Order(int id, int cusid, String status, float tprice, String orderedtime) {
        this.id = id;
        this.cusid = cusid;
        this.status = status;
        this.tprice = tprice;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTprice() {
        return tprice;
    }

    public void setTprice(float tprice) {
        this.tprice = tprice;
    }

    public String getOrderedtime() {
        return orderedtime;
    }

    public void setOrderedtime(String orderedtime) {
        this.orderedtime = orderedtime;
    }
}
