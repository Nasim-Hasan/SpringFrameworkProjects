package com.example.SpringBootMSSQLServer.Controller;

import com.example.SpringBootMSSQLServer.Model.Order;
import com.example.SpringBootMSSQLServer.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public Order create(@Valid @RequestBody Map<String,String> body) {
        Order order = new Order();

        String address = body.get("address");
        String date = body.get("date");

        order.setAddress(address);
        order.setDate(date);

        return orderService.createOrder(order);
    }
}
