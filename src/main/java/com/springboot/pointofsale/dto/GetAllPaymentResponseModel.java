package com.mypayapp.model;


import java.util.List;

public class GetAllPaymentResponseModel {

    private List<AllPaymentModel> paymentList;
    private int dataCount;

    public List<AllPaymentModel> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<AllPaymentModel> paymentList) {
        this.paymentList = paymentList;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }
}
