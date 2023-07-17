package com.example.Client;

import com.example.Service.WholeSaleOrderService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
@Component
public class Wholesaler {
    @Autowired
    private WholeSaleOrderService wholeSaleOrderService;

    public void buySomethingInBulk() {
        wholeSaleOrderService.placeOrder("Car", 100);
    }

}
