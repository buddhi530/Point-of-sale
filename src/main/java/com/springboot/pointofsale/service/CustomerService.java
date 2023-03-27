package com.mypayapp.service;

import com.mypayapp.model.*;

public interface CustomerService {
    BaseResponse getOtpVerificationCustomer(CustomerRequestModel customerRequestModel);

    BaseResponse verifyedCustomer(CustomerVerifyOtpRequestModel customerVerifyOtpModel);

    BaseResponse saveCustomer(CustomerSaveRequestModel customerSaveRequestModel);

    BaseResponse updateCustomer(CustomerUpdateRequestModel customerUpdateRequestModel);

}
