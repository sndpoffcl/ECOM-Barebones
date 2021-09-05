package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Product;

import java.util.List;

public interface ProductService {
    public Product acceptProductDetails(Product product);
    public Product getProductDetails(int id);
    public Product updateProductDetails(Product product);
    public List<Product> getAllProducts();
}
