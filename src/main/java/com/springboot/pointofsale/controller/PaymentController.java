package com.mypayapp.controller;

import com.mypayapp.model.BaseResponse;
import com.mypayapp.model.GetAllPaymentResponseModel;
import com.mypayapp.model.PaymentRequestModel;
import com.mypayapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(path = "/save")
    public ResponseEntity<BaseResponse> savePaymentMethods(@RequestBody PaymentRequestModel paymentRequestModel){
        BaseResponse response = paymentService.savePaymentMethods(paymentRequestModel);
        return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
    }

    @GetMapping (path = "/get-all-payment")
    public ResponseEntity<BaseResponse<GetAllPaymentResponseModel>> getAllPaymentData(
            @RequestParam(value = "page") int page,@RequestParam(value = "size") int size){
        BaseResponse<GetAllPaymentResponseModel> response = paymentService.getAllPaymentData(page,size);
        return  new ResponseEntity<BaseResponse<GetAllPaymentResponseModel>>(response,HttpStatus.OK);
    }
}
