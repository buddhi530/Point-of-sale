package com.mypayapp.service;

import com.mypayapp.model.BaseResponse;
import com.mypayapp.model.GetAllPaymentResponseModel;
import com.mypayapp.model.PaymentRequestModel;

public interface PaymentService {
    BaseResponse savePaymentMethods(PaymentRequestModel paymentRequestModel);

    BaseResponse<GetAllPaymentResponseModel> getAllPaymentData(int page, int size);
}
