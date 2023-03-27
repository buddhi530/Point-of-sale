package com.mypayapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "counter")
public class Counter {

    @Id
    @Column(name="counter_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="counter_name")
    private  String name;

    @ManyToOne
    @JoinColumn(name="shop_id", nullable=false)
    private Shop shop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
