package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Customer;

import java.util.List;

public interface CustomerService {
    public Customer acceptCustomerDetails(Customer customer);
    public Customer getCustomerDetails(int id);
    public Customer updateCustomerDetails(Customer customer);
    public List<Customer> getAllCustomers();
}
