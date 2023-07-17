package com.example.Service;

import org.springframework.stereotype.Service;
@Service
public class RetailOrderService {
    public void placeOrder(String item) {
            System.out.printf("Retail order placed. Item: %s%n", item);
        }

}
