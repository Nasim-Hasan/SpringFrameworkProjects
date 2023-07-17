package com.example.Client;

import com.example.Service.RetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Buyer {
    @Autowired
    private RetailOrderService orderService;

    public void buySomething() {
        orderService.placeOrder("Laptop");
    }
}
