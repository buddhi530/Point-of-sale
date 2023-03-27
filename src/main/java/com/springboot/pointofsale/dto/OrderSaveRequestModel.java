package com.mypayapp.model;

import com.mypayapp.entity.OrderDetails;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderSaveRequestModel {

    private int customer;

    private Date date;

    private double total;

    private List<OrderDetailsRequestModel> orderDetailsSet;

    private int paymentMethod;

    private int shop;

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getShop() {
        return shop;
    }

    public void setShop(int shop) {
        this.shop = shop;
    }

    public List<OrderDetailsRequestModel> getOrderDetailsSet() {
        return orderDetailsSet;
    }

    public void setOrderDetailsSet(List<OrderDetailsRequestModel> orderDetailsSet) {
        this.orderDetailsSet = orderDetailsSet;
    }

}
