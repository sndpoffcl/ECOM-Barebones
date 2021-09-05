package com.upgrad.ECOM.service;

import com.upgrad.ECOM.dto.OrderRequest;
import com.upgrad.ECOM.entity.Order;

import java.util.List;

public interface OrderService {
    public Order placeOrder(OrderRequest orderRequest);
    public Order cancelOrder(int orderId);
    public Order getOrderDetails(int orderId);
    public List<Order> getAllOrders();
    public List<Order> getOrderForCustomer(int customerId);
}
