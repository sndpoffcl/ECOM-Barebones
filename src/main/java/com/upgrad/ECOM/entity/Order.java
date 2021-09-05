package com.upgrad.ECOM.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private int amount;
    private String date;

    private Customer customer;

    private List<Product> products;

    public Order(int id, int amount, String date, Customer customer, List<Product> products) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.customer = customer;
        this.products = products;
    }

    public Order() {
    }
}
