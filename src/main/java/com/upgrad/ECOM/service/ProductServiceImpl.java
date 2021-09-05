package com.upgrad.ECOM.service;

import com.upgrad.ECOM.entity.Product;
import com.upgrad.ECOM.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product acceptProductDetails(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductDetails(int id) {
        return productRepo.findById(id);
    }

    @Override
    public Product updateProductDetails(Product product) {
        return productRepo.update(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}
