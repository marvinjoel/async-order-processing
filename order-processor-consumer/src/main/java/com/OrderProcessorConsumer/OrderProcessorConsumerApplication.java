package com.OrderProcessorConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.OrderProcessorConsumer.repository")
public class OrderProcessorConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderProcessorConsumerApplication.class, args);
	}

}
