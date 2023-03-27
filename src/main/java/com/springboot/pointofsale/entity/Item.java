package com.mypayapp.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name="item_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "item_name",nullable = false)
    private String itemName;

    @Column(name = "suplier_price",nullable = false)
    private double supplierPrice;

    @Column(name = "sell_price",nullable = false)
    private double sellingPrice;

    @Column(name = "balance_qty",nullable = false)
    private double balanceqty;

    @Column(name = "status")
    private boolean activeStatus;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetailsSet;

}
