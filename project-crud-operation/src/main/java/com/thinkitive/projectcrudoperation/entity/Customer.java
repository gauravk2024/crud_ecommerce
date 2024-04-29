package com.thinkitive.projectcrudoperation.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private LocalDate dob;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cust_id", referencedColumnName = "id")
    private List<Address> address;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_product",
            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "pdoduct_id"))
    private List<Product> products = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "customer_order",
//            joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "order_id"))
//    private List<CustomerOrder> orders = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_cust_id_ord", referencedColumnName = "id")
    private List<CustomerOrder> orders;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "home_id")
//    private List<Home_Address> homeAddress;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "cust_office_id")
//    private List<OfficeAddress> officeAddresses;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String email, String gender, LocalDate dob, List<Address> address, List<Product> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<CustomerOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

//    public List<Home_Address> getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(List<Home_Address> homeAddress) {
//        this.homeAddress = homeAddress;
//    }
//
//    public List<OfficeAddress> getOfficeAddresses() {
//        return officeAddresses;
//    }
//
//    public void setOfficeAddresses(List<OfficeAddress> officeAddresses) {
//        this.officeAddresses = officeAddresses;
//    }
}