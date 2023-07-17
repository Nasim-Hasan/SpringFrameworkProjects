package com.example.Service;

import org.springframework.stereotype.Service;

@Service
public class WholeSaleOrderService {
    public void placeOrder(String item, int quantity) {
        if (quantity < 10) {
            throw new IllegalArgumentException(
                    "Quantity must be more than 10  for a wholesale order");
        }
        System.out.printf("Wholesale order placed. Item: %s Quantity: %s%n", item, quantity);
    }

}
