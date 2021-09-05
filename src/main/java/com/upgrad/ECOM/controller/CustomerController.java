package com.upgrad.ECOM.controller;

import com.upgrad.ECOM.entity.Customer;
import com.upgrad.ECOM.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customer/{id}")
    public ResponseEntity getCustomerDetails(@PathVariable("id") int id){
        Customer savedCustomer = customerService.getCustomerDetails(id);
        if(savedCustomer == null){
            return ResponseEntity.ok("Customer Details not found");
        }else{
            return ResponseEntity.ok(savedCustomer);
        }
    }

    @PostMapping("/customer")
    public ResponseEntity acceptCustomerDetails(@RequestBody Customer customer){
        Customer savedCustomer = customerService.acceptCustomerDetails(customer);
        if(savedCustomer == null){
            return ResponseEntity.ok("Customer already exists");
        }else{
            return ResponseEntity.ok(savedCustomer);
        }
    }

    @PutMapping("/customer")
    public ResponseEntity updateCustomerDetails(@RequestBody Customer customer){
        Customer savedCustomer = customerService.updateCustomerDetails(customer);
        if(savedCustomer == null){
            return ResponseEntity.ok("Customer does not exist");
        }else{
            return ResponseEntity.ok(savedCustomer);
        }
    }

    @GetMapping("/customer")
    public ResponseEntity getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
