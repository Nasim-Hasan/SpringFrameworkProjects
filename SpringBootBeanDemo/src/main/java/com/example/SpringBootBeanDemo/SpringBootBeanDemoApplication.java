package com.example.SpringBootBeanDemo;

import com.example.SpringBootBeanDemo.Component.College;
import com.example.SpringBootBeanDemo.Configuration.CollegeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootBeanDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeanDemoApplication.class, args);
		// Using AnnotationConfigApplicationContext
		// instead of ClassPathXmlApplicationContext
		// because we are not using XML Configuration
		ApplicationContext context
				= new AnnotationConfigApplicationContext(
				CollegeConfiguration.class);

		// Getting the bean
		College college
				= context.getBean("collegeBean", College.class);

		// Invoking the method
		// inside main() method
		college.test();
	}

}
