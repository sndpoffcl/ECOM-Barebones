package com.upgrad.ECOM.entity;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private String password;
    private String gender;

    private List<Order> orders;

    public Customer(int id, String name, String phoneNumber, String address, String email, String password, String gender, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.orders = orders;
    }

    public Customer() {
    }
}
