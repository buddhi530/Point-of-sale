package com.mypayapp.service;

import com.mypayapp.model.BaseResponse;
import com.mypayapp.model.OrderSaveRequestModel;

public interface OrderService {
    BaseResponse saveOrder(OrderSaveRequestModel orderSaveRequestModel);
}
