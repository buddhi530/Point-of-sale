package com.mypayapp.model;

public class CustomerVerifyOtpRequestModel {

    private int mobile;
    private int otp;

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
