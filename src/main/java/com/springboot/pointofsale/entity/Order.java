package com.mypayapp.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date")
    private Date date;

    @Column(name = "total_price",nullable  = false)
    private double total;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetailsSet;

    @ManyToOne
    @JoinColumn(name="payment_id", nullable=false)
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name="shop_id", nullable=false)
    private Shop shop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer(Customer byId) {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate(Date date) {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal(double total) {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<OrderDetails> getOrderDetailsSet() {
        return orderDetailsSet;
    }

    public void setOrderDetailsSet(Set<OrderDetails> orderDetailsSet) {
        this.orderDetailsSet = orderDetailsSet;
    }

    public PaymentMethod getPaymentMethod(PaymentMethod byId) {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Shop getShop(Shop byId) {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
