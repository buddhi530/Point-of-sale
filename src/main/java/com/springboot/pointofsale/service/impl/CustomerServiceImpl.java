package com.mypayapp.service.serviceImpl;

import com.mypayapp.entity.Customer;
import com.mypayapp.model.*;
import com.mypayapp.repository.CustomerRepository;
import com.mypayapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public BaseResponse getOtpVerificationCustomer(CustomerRequestModel customerRequestModel) {

        BaseResponse response = new BaseResponse<>();
        int randomPin   =(int) (Math.random()*9000)+1000;

        if(!customerRepository.existsByMobile(customerRequestModel.getMobile())) {
            Customer customer = new Customer();
            customer.setMobile(customerRequestModel.getMobile());
            customer.setIsRegistered(0);
            customer.setOtp(randomPin);

            customerRepository.saveAndFlush(customer);
               // customerResponseModel.setMobile(customerRepository.ge);
                response.setMessage("login otp : " + randomPin + " || user id is : "  + customer.getId());
                response.setStatus("1");
        }else {
            response.setMessage("already your phone number in the database");
            response.setStatus("-1");
        }
        return response;
    }

    @Override
    public BaseResponse verifyedCustomer(CustomerVerifyOtpRequestModel customerVerifyOtpModel) {

        BaseResponse response = new BaseResponse();

        if(customerRepository.existsByMobile(customerVerifyOtpModel.getMobile())){

            if(customerRepository.existsByMobileEqualsAndOtpEquals(customerVerifyOtpModel.getMobile(),customerVerifyOtpModel.getOtp())){

                response.setStatus("1");
                response.setMessage("user verifyed  & move to the dashboard page!");
            }else {

                response.setStatus("-1");
                response.setMessage("otp did not match!");
            }
            }else{
            response.setStatus("-1");
            response.setMessage("user mobile number not found");

        }
        return response;
        }

    @Override
    public BaseResponse saveCustomer(CustomerSaveRequestModel customerSaveRequestModel) {

        BaseResponse response = new BaseResponse<>();

        if(customerRepository.existsByMobile(customerSaveRequestModel.getMobile())){

            Customer customer=customerRepository.getByMobile(customerSaveRequestModel.getMobile());
            System.out.println("cus=>"+customer);
            customer.setName(customerSaveRequestModel.getName());
            customer.setEmail(customerSaveRequestModel.getEmail());
            customer.setAddress(customerSaveRequestModel.getAddress());
            customer.setIsRegistered(1);

            customerRepository.saveAndFlush(customer);
            response.setStatus("1");
            response.setMessage("user data saved successfully!" + "user ID : " +customer.getId());
        }else{

            response.setStatus("1");
            response.setMessage("user phone number not found !");
        }

        return response;
    }

    @Override
    public BaseResponse updateCustomer(CustomerUpdateRequestModel customerUpdateRequestModel) {

        BaseResponse response = new BaseResponse<>();

        if(customerRepository.existsById(customerUpdateRequestModel.getUserId())){
            Customer customer = customerRepository.getById(customerUpdateRequestModel.getUserId());
            customer.setName(customerUpdateRequestModel.getName());
            customer.setEmail(customerUpdateRequestModel.getEmail());
            customer.setAddress(customerUpdateRequestModel.getAddress());

            customerRepository.saveAndFlush(customer);
            response.setStatus("1");
            response.setMessage("user details updated successfully!");
        }else{
            response.setStatus("-1");
            response.setMessage("user id not found in the db!");
        }
        return response;
    }


}

