package com.thinkitive.projectcrudoperation.order;

import com.thinkitive.projectcrudoperation.entity.CustomerOrder;
import com.thinkitive.projectcrudoperation.serviceimpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/order/get/{order_id}")
    public ResponseEntity<?> getOrderById(@PathVariable int order_id){
        CustomerOrder getOrder = orderService.getOrderById(order_id);
        if (getOrder != null) {
            return ResponseEntity.ok().body(getOrder);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order with ID " + order_id + " not found");
        }
    }

    @GetMapping("/order/getall")
    public ResponseEntity<?> getAllOrders(){
        List<CustomerOrder> allOrders = orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @PostMapping("/order/create")
    public ResponseEntity<?> createOrder(@RequestBody CustomerOrder order) {
        CustomerOrder createdOrder = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Order created successfully");
    }

    @DeleteMapping("/order/delete/{order_id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable int order_id){
        orderService.deleteOrderById(order_id);
        return ResponseEntity.ok().body("Order deleted successfully");
    }

    @PutMapping("/order/update/{order_id}")
    public ResponseEntity<?> updateOrder(@PathVariable int order_id){
        CustomerOrder updatedOrder = orderService.updateOrder(order_id);
        return ResponseEntity.ok().body("Order updated successfully");
    }

    @GetMapping("/order/totalAmount/{order_id}")
    public double totalOrderAmount(@PathVariable int order_id){
       double totalAmount=orderService.getTotal(order_id);
        return totalAmount;
    }

    @GetMapping("/order/discount/{order_id}")
        public double totalDiscount(@PathVariable int order_id){
        double discount = orderService.discountOrder(order_id);
        return discount;
    }
}