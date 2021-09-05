package com.upgrad.ECOM.controller;

import com.upgrad.ECOM.entity.Product;
import com.upgrad.ECOM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public ResponseEntity getProductDetails(@PathVariable("id") int id){
        Product savedProduct = productService.getProductDetails(id);
        if(savedProduct == null){
            return ResponseEntity.ok("Product Details not found");
        }else{
            return ResponseEntity.ok(savedProduct);
        }
    }

    @PostMapping("/product")
    public ResponseEntity acceptProductDetails(@RequestBody Product product){
        Product savedProduct = productService.acceptProductDetails(product);
        if(savedProduct == null){
            return ResponseEntity.ok("Product already exists");
        }else{
            return ResponseEntity.ok(savedProduct);
        }
    }

    @PutMapping("/product")
    public ResponseEntity updateProductDetails(@RequestBody Product product){
        Product savedProduct = productService.updateProductDetails(product);
        if(savedProduct == null){
            return ResponseEntity.ok("Product does not exist");
        }else{
            return ResponseEntity.ok(savedProduct);
        }
    }

    @GetMapping("/product")
    public ResponseEntity getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
