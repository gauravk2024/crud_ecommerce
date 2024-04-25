package com.thinkitive.projectcrudoperation.entity;

import jakarta.persistence.*;
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int homeNumber;
    private long zipcode;
    private String city;
    private String state;

    public Address() {
    }

    public Address(int homeNumber, long zipcode, String city, String state) {
        this.homeNumber = homeNumber;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}