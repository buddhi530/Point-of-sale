package com.mypayapp.entity;



import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private  String name;

    @Column(name="email",unique = true)
    private  String email;

    @Column(name="address")
    private  String address;

    @Column(name = "mobile")
    private int mobile;

    @Column(name = "otp")
    private int otp;

    @Column(name = "isRegistered")
    private int isRegistered;


    @OneToMany(mappedBy="customer")
    private Set<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy="customer")
    private Set<Order> orders;


    public int getIsRegistered(int i) {
        return isRegistered;
    }

    public void setIsRegistered(int isRegistered) {
        this.isRegistered = isRegistered;
    }

    public int getMobile() {
        return mobile;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public Customer() {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;

    }
}
