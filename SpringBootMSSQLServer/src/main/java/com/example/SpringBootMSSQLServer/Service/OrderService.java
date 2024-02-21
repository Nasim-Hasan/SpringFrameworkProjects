package com.example.SpringBootMSSQLServer.Service;

import com.example.SpringBootMSSQLServer.Model.Order;
import com.example.SpringBootMSSQLServer.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
    public void deleteOrder(int orderId){orderRepository.deleteById(orderId);}

    public List<Order> getAllOrders(){return orderRepository.findAll();}

    public Optional<Order> getOneOrder(int orderId){return orderRepository.findById(orderId);}

    public List<Order> searchingOrder(String searchTerm){return orderRepository.findByAddress(searchTerm);}

    public Order updatingOrder(Order order){return orderRepository.save(order);}
    public Order partialUpdatingCity(Order order){return orderRepository.save(order);}
}
