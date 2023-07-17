package com.example.ComponentScanDemo;

import com.example.Client.Buyer;
import com.example.Client.Wholesaler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.client","com.example.service"})
public class ComponentScanDemoApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(ComponentScanDemoApplication.class);
		System.out.println("-- Spring container started and is ready --");
		Buyer buyer = context.getBean(Buyer.class);
		buyer.buySomething();

		Wholesaler wholesaler = context.getBean(Wholesaler.class);
		wholesaler.buySomethingInBulk();

	}

}
