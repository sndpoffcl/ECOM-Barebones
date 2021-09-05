package com.upgrad.ECOM.repository;

import com.upgrad.ECOM.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerRepo {

    private static HashMap<Integer, Customer> customerDB = new HashMap<>();

    public Customer save(Customer customer){
        int customerId = customer.getId();
        if(customerDB.containsKey(customerId)){
            System.out.println("Customer ID already exists");
            return null;
        }else{
            System.out.println("New customer entry done");
            customerDB.put(customer.getId(), customer);
            return customer;
        }
    }


    public Customer findById(int customerId){
        if(customerDB.containsKey(customerId)){
            System.out.println("Customer found");
            return customerDB.get(customerId);
        }else{
            System.out.println("Customer details not found");
            return null;
        }
    }

    public Customer update(Customer customer){
        if(customerDB.containsKey(customer.getId())){
            System.out.println("Customer has been updated");
            customerDB.put(customer.getId(), customer);
            return customer;
        }else{
            System.out.println("Customer doesnt exist");
            return null;
        }
    }

    public List<Customer> findAll(){
        List<Customer> customers = new ArrayList<>(customerDB.values());
        return customers;
    }


}
