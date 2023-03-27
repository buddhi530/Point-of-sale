package com.mypayapp.model;

import com.mypayapp.entity.Item;
import com.mypayapp.entity.Order;

import javax.persistence.*;

public class OrderDetailsRequestModel {

    private String itemName;

    private double qty;

    private double itemAmount;

    //in the request model we cannot send this first time cos it is not created a id first time
    //private int orders;

    private int items;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

//    public int getOrders() {
//        return orders;
//    }
//
//    public void setOrders(int orders) {
//        this.orders = orders;
//    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }
}
