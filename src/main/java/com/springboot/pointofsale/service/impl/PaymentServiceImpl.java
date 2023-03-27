package com.mypayapp.service.serviceImpl;

import com.mypayapp.entity.PaymentMethod;
import com.mypayapp.model.AllPaymentModel;
import com.mypayapp.model.BaseResponse;
import com.mypayapp.model.GetAllPaymentResponseModel;
import com.mypayapp.model.PaymentRequestModel;
import com.mypayapp.repository.CustomerRepository;
import com.mypayapp.repository.PaymentRepository;
import com.mypayapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public BaseResponse savePaymentMethods(PaymentRequestModel paymentRequestModel) {

        BaseResponse response = new BaseResponse();

        DateFormat date = new SimpleDateFormat("dd-MM-yyyy hh.mm aa", Locale.getDefault());

        PaymentMethod paymentMethod = new PaymentMethod();
        System.out.println("date=>"+paymentRequestModel.getExpireDate());
        paymentMethod.setExpireDate(paymentRequestModel.getExpireDate());
        paymentMethod.setCardNumber(paymentRequestModel.getCardNumber());
        paymentMethod.setCvc(paymentRequestModel.getCvc());
        paymentMethod.setCustomer(customerRepository.getById(paymentRequestModel.getCustomer()));

        if(!paymentRepository.existsById(paymentMethod.getId())){
            //System.out.println("id=>"+paymentMethod.getId());
            paymentRepository.saveAndFlush(paymentMethod);
            response.setMessage("card details saved successfully!");
            response.setStatus("1");

        }else{
            response.setStatus("-1");
            response.setMessage("card details already exist!");
        }

        return response;
    }

    @Override
    public BaseResponse<GetAllPaymentResponseModel> getAllPaymentData(int page, int size) {

        BaseResponse<GetAllPaymentResponseModel> response = new BaseResponse<>();
        GetAllPaymentResponseModel getAllPaymentResponseModel = new GetAllPaymentResponseModel();
        List<AllPaymentModel> paymentModelList = new ArrayList<>();

        Page<Object[]> resultPages = paymentRepository.getPaymentDetails(PageRequest.of(page,size));

        if (resultPages != null || !resultPages.isEmpty()) {
            for (Object[] row : resultPages) {
                AllPaymentModel model = new AllPaymentModel();
                DateFormat date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                model.setPaymentId((Integer) row[0]);
                    model.setCardExpireDate(date.format(row[1]));


                model.setPaymentCardNumber((String) row[2]);
                model.setCustomerName((String) row[3]);
                model.setCustomerAddress((String) row[4]);
                model.setOrderDate(date.format(row[5]));
                model.setTotalPrice((String) row[6].toString());
                paymentModelList.add(model);
            }
            getAllPaymentResponseModel.setPaymentList(paymentModelList);
            getAllPaymentResponseModel.setDataCount((int) resultPages.getTotalElements());
            response.setPayLoad(getAllPaymentResponseModel);
            response.setStatus("1");
            response.setMessage("get the all data");

        }else{
            response.setStatus("-1");
            response.setMessage("no data!");
        }

        return response;
    }
}
