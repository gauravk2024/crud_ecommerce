package com.thinkitive.projectcrudoperation.service;

import com.thinkitive.projectcrudoperation.entity.CustomerOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<CustomerOrder> getAllOrders();
    CustomerOrder getOrderById(int order_id);
    CustomerOrder saveOrder(CustomerOrder order);
    void deleteOrderById(int order_id);
    CustomerOrder updateOrder(int order_id);
    double getTotal(int order_id);
    double discountOrder(int order_id);
}