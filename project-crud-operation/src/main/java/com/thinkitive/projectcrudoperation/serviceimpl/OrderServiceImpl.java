package com.thinkitive.projectcrudoperation.serviceimpl;

import com.thinkitive.projectcrudoperation.entity.CustomerOrder;
import com.thinkitive.projectcrudoperation.repository.OrderRepository;
import com.thinkitive.projectcrudoperation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public CustomerOrder getOrderById(int order_id) {
        return orderRepository.findById(order_id).get();
    }

    @Override
    public CustomerOrder saveOrder(CustomerOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(int order_id) {
        orderRepository.deleteById(order_id);
    }

    @Override
    public CustomerOrder updateOrder(int order_id) {
        CustomerOrder order = orderRepository.findById(order_id).get();
        if (order != null) {
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public double getTotal(int order_id) {
        CustomerOrder cOrder=orderRepository.findById(order_id).get();
        double price=cOrder.getPrice();
        int quantity=cOrder.getQuantity();

        double totalAmount=price*quantity;
        return totalAmount;
    }

    @Override
    public double discountOrder(int order_id) {
        CustomerOrder customerOrder = orderRepository.findById(order_id).get();
        double price = customerOrder.getPrice();
        double discount = 10;
        double discountAmount = price * (discount/100);
        double finalAmount = price - discountAmount;
        return finalAmount;
    }
}