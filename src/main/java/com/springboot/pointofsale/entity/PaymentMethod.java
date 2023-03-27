package com.mypayapp.entity;

import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "cvc")
    private int cvc;

    @Column(name = "expire_date")
    private Date expireDate;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToMany(mappedBy="paymentMethod")
    private Set<Order> orderSet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


}
