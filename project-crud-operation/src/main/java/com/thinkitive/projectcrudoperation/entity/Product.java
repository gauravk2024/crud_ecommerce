package com.thinkitive.projectcrudoperation.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pdoduct_id;
    private String name;
    private String description;
    private double price;
    @Lob
    private byte[] image;
    @Lob
    private byte[] image1;
    @Lob
    private byte[] image2;

//    @JsonIgnore
//    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
//    private List<Customer> customers = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "product_category",
//            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "pdoduct_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
//    private List<Category> categories = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_prod_id", referencedColumnName = "pdoduct_id")
    private List<Category> categories;

    public Product() {
    }

    public Product(int pdoduct_id, String name, String description, double price, byte[] image, byte[] image1, byte[] image2, List<Category> categories) {
        this.pdoduct_id = pdoduct_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.categories = categories;
    }

    public int getPdoduct_id() {
        return pdoduct_id;
    }

    public void setPdoduct_id(int pdoduct_id) {
        this.pdoduct_id = pdoduct_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }
}