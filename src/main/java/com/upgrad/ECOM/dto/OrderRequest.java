package com.upgrad.ECOM.dto;

import com.upgrad.ECOM.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private int customerId;
    private List<Integer> productId;
    private List<Integer> quantity;
}
