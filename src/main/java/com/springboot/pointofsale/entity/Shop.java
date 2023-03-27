package com.mypayapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @Column(name="shop_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="shop_name")
    private  String name;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy="shop")
    private Set<Order> orderSet;

    @OneToMany(mappedBy="shop")
    private Set<Counter> counterSet;

    @ManyToOne
    @JoinColumn(name="mechant_id", nullable=false)
    private Mechant mechant;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public Set<Counter> getCounterSet() {
        return counterSet;
    }

    public void setCounterSet(Set<Counter> counterSet) {
        this.counterSet = counterSet;
    }

    public Mechant getMechant() {
        return mechant;
    }

    public void setMechant(Mechant mechant) {
        this.mechant = mechant;
    }
}
