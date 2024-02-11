package com.example.SpringBootMSSQLServer.Repository;

import com.example.SpringBootMSSQLServer.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
