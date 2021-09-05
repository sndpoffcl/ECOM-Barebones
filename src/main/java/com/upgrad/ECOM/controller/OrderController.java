package com.upgrad.ECOM.controller;

import com.upgrad.ECOM.dto.OrderRequest;
import com.upgrad.ECOM.entity.Order;
import com.upgrad.ECOM.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity placeOrder(@RequestBody OrderRequest orderRequest){
        Order placedOrder = orderService.placeOrder(orderRequest);
        if(placedOrder == null){
            return ResponseEntity.ok("Placing Order failed");
        }else{
            return ResponseEntity.ok(placedOrder);
        }
    }
}
