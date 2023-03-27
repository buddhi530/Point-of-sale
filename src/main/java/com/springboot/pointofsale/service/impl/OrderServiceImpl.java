package com.mypayapp.service.serviceImpl;

import com.mypayapp.entity.Order;
import com.mypayapp.entity.OrderDetails;
import com.mypayapp.model.BaseResponse;
import com.mypayapp.model.OrderSaveRequestModel;
import com.mypayapp.repository.*;
import com.mypayapp.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Transactional
    @Override
    public BaseResponse saveOrder(OrderSaveRequestModel orderSaveRequestModel) {
        BaseResponse response = new BaseResponse();

        Order order = new Order();
        order.setCustomer(customerRepository.getById(orderSaveRequestModel.getCustomer()));
        order.setDate(orderSaveRequestModel.getDate());
        order.setPaymentMethod(paymentRepository.getById(orderSaveRequestModel.getPaymentMethod()));
        order.setShop(shopRepository.getById(orderSaveRequestModel.getShop()));
        order.setTotal(orderSaveRequestModel.getTotal());

        orderRepository.save(order);

        if(orderRepository.existsById(order.getId())){
            System.out.println("orderId=>"+order.getId());

            List<OrderDetails> orderDetailsList = modelMapper.map(orderSaveRequestModel.getOrderDetailsSet(),
                    new TypeToken<List<OrderDetails>>(){}.getType());

            for(int i =0;i<orderDetailsList.size();i++){
                orderDetailsList.get(i).setOrders(order);
                orderDetailsList.get(i).setItems(itemRepository.getById(orderSaveRequestModel.getOrderDetailsSet().get(i).getItems()));
            }

            if(orderDetailsList.size()>0){
                List<OrderDetails> orderDetails=orderDetailsRepository.saveAll(orderDetailsList);
                response.setStatus("1");
                response.setPayLoad(orderDetails);
                response.setMessage("orderDetails and order saved succesfully!");
            }else {
                response.setMessage("orderDetails not saved!");
                response.setStatus("-1");
            }
        }

        return response;
    }
}
