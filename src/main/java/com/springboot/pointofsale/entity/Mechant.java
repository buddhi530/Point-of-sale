package com.mypayapp.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mechant")
public class Mechant {

    @Id
    @Column(name="mechant_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="mechant_name")
    private  String name;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private int contact;

    @OneToMany(mappedBy="mechant")
    private Set<Shop> shopSet;

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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public Set<Shop> getShopSet() {
        return shopSet;
    }

    public void setShopSet(Set<Shop> shopSet) {
        this.shopSet = shopSet;
    }
}
