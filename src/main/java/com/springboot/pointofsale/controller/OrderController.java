package com.mypayapp.controller;

import com.mypayapp.model.BaseResponse;
import com.mypayapp.model.OrderSaveRequestModel;
import com.mypayapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "save")
    public ResponseEntity<BaseResponse> saveOrder(@RequestBody OrderSaveRequestModel orderSaveRequestModel){
        System.out.println("order=>"+orderSaveRequestModel);
        BaseResponse response = orderService.saveOrder(orderSaveRequestModel);
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }
}
