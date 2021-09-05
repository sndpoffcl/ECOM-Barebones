package com.upgrad.ECOM.repository;

import com.upgrad.ECOM.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepo {
    private static HashMap<Integer, Order> orderDB = new HashMap<>();

    public Order save(Order order){
        int orderId = order.getId();
        if(orderDB.containsKey(orderId)){
            System.out.println("Order ID already exists");
            return null;
        }else{
            System.out.println("New order entry done");
            orderDB.put(order.getId(), order);
            return order;
        }
    }


    public Order findById(int id){
        if(orderDB.containsKey(id)){
            System.out.println("Order found");
            return orderDB.get(id);
        }else{
            System.out.println("Order details not found");
            return null;
        }
    }

    public Order update(Order order){
        if(orderDB.containsKey(order.getId())){
            System.out.println("Order has been updated");
            orderDB.put(order.getId(), order);
            return order;
        }else{
            System.out.println("Order doesnt exist");
            return null;
        }
    }

    public List<Order> findAll(){
        List<Order> orders = new ArrayList<>(orderDB.values());
        return orders;
    }
}
