package com.model;

public class DraftItem extends Item {

    private String note;

    public DraftItem (int id, String name, String des, double price, String category, String image) {
        super(id, name, des, price, category, image);
    }

    //convert DraftItem to Item object
    public Item convertToItem() {
        return new Item(this.getId(), this.getName(), this.getDescription(), this.getPrice(), this.getCategory(), this.getImage());
    }

}

