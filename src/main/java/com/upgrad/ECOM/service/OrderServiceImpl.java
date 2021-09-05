package com.upgrad.ECOM.service;

import com.upgrad.ECOM.dto.OrderRequest;
import com.upgrad.ECOM.entity.Customer;
import com.upgrad.ECOM.entity.Order;
import com.upgrad.ECOM.entity.Product;
import com.upgrad.ECOM.repository.CustomerRepo;
import com.upgrad.ECOM.repository.OrderRepo;
import com.upgrad.ECOM.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Order placeOrder(OrderRequest orderRequest) {
        List<Integer> products = orderRequest.getProductId();
        List<Integer> quantity = orderRequest.getQuantity();
        List<Product> orderedProducts = new ArrayList<>();
        int totalAmount = 0;
        for(int i=0;i<products.size();i++){
            int productId = products.get(i);
            int productQuantity = quantity.get(i);
            Product savedProduct = productRepo.findById(productId);
            if(savedProduct == null){
                System.out.println("Ordered product does not exist");
                return null;
            }else{
                if(savedProduct.getQuantity() < productQuantity){
                    System.out.println("Insufficient quantity");
                    return null;
                }else{
                   totalAmount = totalAmount + (savedProduct.getPrice() * productQuantity);
                   savedProduct.setQuantity(savedProduct.getQuantity() - productQuantity);
                   orderedProducts.add(savedProduct);
                   productRepo.update(savedProduct);
                }
            }
        }

        Order order = new Order();
        order.setId((int)Math.random() * 100000);
        order.setAmount(totalAmount);
        order.setCustomer(customerRepo.findById(orderRequest.getCustomerId()));
        order.setProducts(orderedProducts);
        orderRepo.save(order);
        Customer customer = customerRepo.findById(orderRequest.getCustomerId());
        ArrayList<Order> customerOrders = (ArrayList<Order>) customer.getOrders();
        customerOrders.add(order);
        customer.setOrders(customerOrders);
        customerRepo.update(customer);
        return order;
    }

    @Override
    public Order cancelOrder(int orderId) {
        return null;
    }

    @Override
    public Order getOrderDetails(int orderId) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public List<Order> getOrderForCustomer(int customerId) {
        return null;
    }
}
