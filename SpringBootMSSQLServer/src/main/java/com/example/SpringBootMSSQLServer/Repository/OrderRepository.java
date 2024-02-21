package com.example.SpringBootMSSQLServer.Repository;

import com.example.SpringBootMSSQLServer.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByAddress(String address);
}
