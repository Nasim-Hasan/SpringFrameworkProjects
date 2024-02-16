package com.example.SpringBootMyBatisDemo.Domain;

import com.example.SpringBootMyBatisDemo.Model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    void insertOrder(Order order);
    Order findOrderById(int id);
    List<Order> findAllOrders();
}
