package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Customer;
import com.upgrad.ECOM.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer acceptCustomerDetails(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer getCustomerDetails(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer updateCustomerDetails(Customer customer) {
        return customerRepo.update(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
