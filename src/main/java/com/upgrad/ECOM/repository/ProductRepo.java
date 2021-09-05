package com.upgrad.ECOM.repository;

import com.upgrad.ECOM.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepo {

    private static HashMap<Integer, Product> productDB = new HashMap<>();

    public Product save(Product product){
        int id = product.getId();
        if(productDB.containsKey(id)){
            System.out.println("Product ID already exists");
            return null;
        }else{
            System.out.println("New product entry done");
            productDB.put(product.getId(), product);
            return product;
        }
    }


    public Product findById(int id){
        if(productDB.containsKey(id)){
            System.out.println("Product found");
            return productDB.get(id);
        }else{
            System.out.println("Product details not found");
            return null;
        }
    }

    public Product update(Product product){
        if(productDB.containsKey(product.getId())){
            System.out.println("Product has been updated");
            productDB.put(product.getId(), product);
            return product;
        }else{
            System.out.println("Product doesnt exist");
            return null;
        }
    }

    public List<Product> findAll(){
        List<Product> products = new ArrayList<>(productDB.values());
        return products;
    }
}
