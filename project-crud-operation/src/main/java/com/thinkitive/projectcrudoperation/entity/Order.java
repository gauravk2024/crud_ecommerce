package com.thinkitive.projectcrudoperation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private String name;
    private double price;
    private int quantity;

    @JsonIgnore
    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Customer> customers = new ArrayList<>();

    public Order() {

    }

    public Order(int order_id, String name, double price, int quantity, List<Customer> customers) {
        this.order_id = order_id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.customers = customers;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
