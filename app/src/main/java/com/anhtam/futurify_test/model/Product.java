package com.anhtam.futurify_test.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productId;
    private String productName;
    private String categoryId;
    private double rating;
    private String description;
    private double price;


    public String getProductId() {
        return productId;
    }

    public Product setProductId(String productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public Product setCategoryId(String categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public double getRating() {
        return rating;
    }

    public Product setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
}
