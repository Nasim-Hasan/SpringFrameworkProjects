package com.example.SpringBootMyBatisDemo;

import com.example.SpringBootMyBatisDemo.Domain.OrderMapper;
import com.example.SpringBootMyBatisDemo.Model.Order;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.example.SpringBootMyBatisDemo.Domain")
public class SpringBootMyBatisDemoApplication  implements CommandLineRunner {

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public void run(String...args) throws Exception {

		List<Order> allOrders = orderMapper.findAllOrders();
		System.out.println("All Orders:");

		for (Order tmpOrder: allOrders){
			System.out.println("Address:"+tmpOrder.getAddress()+" Date:"+tmpOrder.getDate());
		}

        Order particularOrder = orderMapper.findOrderById(5);
		System.out.println("A Particular Order:");
		System.out.println("Address:"+particularOrder.getAddress()+" Date:"+particularOrder.getDate());

		orderMapper.insertOrder(new Order("Lisbon","2024-02-17"));
		System.out.println("Inserted an Order.");
		System.out.println("Order Address:"+new Order("Lisbon","2024-02-17").getAddress()+" Order Date:"+new Order("Los Angeles","2024-02-17").getDate());

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisDemoApplication.class, args);

	}

}
