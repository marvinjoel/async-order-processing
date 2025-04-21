package com.OrderApiProducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrderApiProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApiProducerApplication.class, args);
	}

}
