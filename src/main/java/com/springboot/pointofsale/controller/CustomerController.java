package com.mypayapp.controller;

import com.mypayapp.model.*;
import com.mypayapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/generate-otp")
    public ResponseEntity<BaseResponse>getOtpVerificationCustomer (@RequestBody CustomerRequestModel customerRequestModel){

        BaseResponse response = customerService.getOtpVerificationCustomer(customerRequestModel);
    return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
    }

    @PostMapping(path = "verify")
    public ResponseEntity<BaseResponse> verifyedCustomer(@RequestBody CustomerVerifyOtpRequestModel customerVerifyOtpModel){
        BaseResponse response = customerService.verifyedCustomer(customerVerifyOtpModel);
        return  new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
    }

    @PostMapping(path = "save")
    public ResponseEntity<BaseResponse> saveCustomer(@RequestBody CustomerSaveRequestModel customerSaveRequestModel){
        BaseResponse response = customerService.saveCustomer(customerSaveRequestModel);
        return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
    }


    //show the updating data
    @PostMapping(path = "update")
    public ResponseEntity<BaseResponse> updateCustomer(@RequestBody CustomerUpdateRequestModel customerUpdateRequestModel){
        BaseResponse response = customerService.updateCustomer(customerUpdateRequestModel);
         return new ResponseEntity<BaseResponse>(response,HttpStatus.OK);
    }
}
