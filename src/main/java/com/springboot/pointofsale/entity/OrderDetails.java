package com.mypayapp.entity;

import javax.persistence.*;
import javax.xml.soap.Name;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @Column(name="order_details_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private double qty;

    @Column(name = "item_Amount")
    private double itemAmount;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order orders;

    @ManyToOne
    @JoinColumn(name="item_id", nullable=false)
    private Item items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public Item getItems() {
        return items;
    }

    public void setItems(Item items) {
        this.items = items;
    }
}
