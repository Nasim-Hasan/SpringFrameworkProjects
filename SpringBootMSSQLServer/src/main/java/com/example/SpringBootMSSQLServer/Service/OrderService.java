package com.example.SpringBootMSSQLServer.Service;

import com.example.SpringBootMSSQLServer.Model.Order;
import com.example.SpringBootMSSQLServer.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
}