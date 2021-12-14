package com.example.adventure.Model;

import com.example.adventure.Cart;

public class CartItem {
    String itemName, itemImage, itemPoints, itemQty;

    public CartItem() {

    }

    public CartItem(String itemName, String itemPoints, String itemQty) {
        this.itemName = itemName;
        this.itemPoints = itemPoints;
        this.itemQty = itemQty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPoints() {
        return itemPoints;
    }

    public void setItemPoints(String itemPoints) {
        this.itemPoints = itemPoints;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }
}
