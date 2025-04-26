package com.OrderProcessorConsumer.repository;

import com.OrderProcessorConsumer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
