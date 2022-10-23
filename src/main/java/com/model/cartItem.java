package com.model;

public class cartItem {
    private int id;
    private int cartid;
    private String iname;
    private int quantity;

    public cartItem(int id, int cartid, String iname, int quantity) {
        this.id = id;
        this.cartid = cartid;
        this.iname = iname;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public String getIname() {
        return iname;
    }

    public void setIname(String iname) {
        this.iname = iname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}