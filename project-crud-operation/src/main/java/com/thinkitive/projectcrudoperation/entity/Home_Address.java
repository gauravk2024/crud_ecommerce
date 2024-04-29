package com.thinkitive.projectcrudoperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Home_Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int home_id;
    private String name;
    private String city;
    private String state;

    public Home_Address() {
    }

    public Home_Address(int home_id, String name, String city, String state) {
        this.home_id = home_id;
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public int getHome_id() {
        return home_id;
    }

    public void setHome_id(int home_id) {
        this.home_id = home_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
