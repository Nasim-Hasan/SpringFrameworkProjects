package com.example.SpringBootMSSQLServer.Controller;

import com.example.SpringBootMSSQLServer.Model.Order;
import com.example.SpringBootMSSQLServer.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
    @DeleteMapping("/order/{id}")
    public boolean delete(@PathVariable String id){
        int orderId = Integer.parseInt(id);
        try{
            orderService.deleteOrder(orderId);
            return true;
        }
        catch(Exception ex){
            return  false;
        }
    }

    @GetMapping("/order")
    public List<Order> AllOrders(){return orderService.getAllOrders();}
    @GetMapping("/order/{id}")
    public Optional<Order> oneOrder(@PathVariable String id){
        int ordId = Integer.parseInt(id);
        return orderService.getOneOrder(ordId);
    }
    @PostMapping("/order/search")
    public List<Order> searching(@RequestBody Map<String, String> body){
        String searchTerm = body.get("address");
        return orderService.searchingOrder(searchTerm);
    }

    @PutMapping("/order/{id}")
    public Order update(@PathVariable String id, @RequestBody Map<String, String> body){
        int orderId = Integer.parseInt(id);
        // getting order
        Optional<Order> order = orderService.getOneOrder(orderId);
        order.get().setId(Integer.parseInt(body.get("id")));
        order.get().setAddress(body.get("address"));
        order.get().setDate(body.get("date"));
        return orderService.updatingOrder(order.get());
    }

    @PatchMapping("/order/{id}")
    public Order partialUpdate(@PathVariable String id, @RequestBody Map<String, String> body){
        int orderId = Integer.parseInt(id);
        // getting city
        Order order = orderService.getOneOrder(orderId).get();
        Set<String> keys = body.keySet();
        for(String tmpKey:keys){
            if(tmpKey.equalsIgnoreCase("id")){
                String ordrId = body.get("id");
                order.setId(Integer.parseInt(ordrId));
            }
            else if(tmpKey.equalsIgnoreCase("address")){
                String address=body.get("address");
                order.setAddress(address);
            }
            else if (tmpKey.equalsIgnoreCase("date")){
                String date=body.get("date");
                order.setDate(date);
            }

        }
        return orderService.partialUpdatingCity(order);
    }


}

