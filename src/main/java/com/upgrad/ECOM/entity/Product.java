package com.upgrad.ECOM.entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String productName;
    private int quantity;
    private int price;

    public Product(int id, String productName, int quantity, int price) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {
    }
}
