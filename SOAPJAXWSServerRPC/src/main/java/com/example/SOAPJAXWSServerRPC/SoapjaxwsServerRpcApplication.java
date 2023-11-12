package com.example.SOAPJAXWSServerRPC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.xml.ws.Endpoint;

//Endpoint publisher
@SpringBootApplication
public class SoapjaxwsServerRpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapjaxwsServerRpcApplication.class, args);
		Endpoint.publish("http://localhost:8081/ws/hello", new HelloWorldImpl());

	}

}
