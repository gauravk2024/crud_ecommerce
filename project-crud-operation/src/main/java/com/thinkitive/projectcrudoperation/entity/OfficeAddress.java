package com.thinkitive.projectcrudoperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OfficeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int office_id;
    private String name;
    private String landmark;
    private String city;

    public OfficeAddress() {
    }

    public OfficeAddress(int office_id, String name, String landmark, String city) {
        this.office_id = office_id;
        this.name = name;
        this.landmark = landmark;
        this.city = city;
    }

    public int getOffice_id() {
        return office_id;
    }

    public void setOffice_id(int office_id) {
        this.office_id = office_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
