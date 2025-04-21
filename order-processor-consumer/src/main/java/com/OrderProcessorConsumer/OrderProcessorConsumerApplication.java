package com.OrderProcessorConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrderProcessorConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessorConsumerApplication.class, args);
	}

}
