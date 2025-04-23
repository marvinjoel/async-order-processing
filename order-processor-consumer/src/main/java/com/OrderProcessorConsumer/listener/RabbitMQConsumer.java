package com.OrderProcessorConsumer.listener;

import com.OrderProcessorConsumer.dto.OrderRequest;
import com.OrderProcessorConsumer.model.Order;
import com.OrderProcessorConsumer.model.User;
import com.OrderProcessorConsumer.repository.OrderRepository;
import com.OrderProcessorConsumer.service.OrderProcessingService;
import com.OrderProcessorConsumer.service.UserValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private final OrderRepository orderRepository;
    private final UserValidationService userValidationService;
    private final OrderProcessingService orderProcessingService;

    @RabbitListener(queues = {"${rabbitmq.queue.orders.name}"})
    public void consumerOrdersMessage(OrderRequest orderRequest){
        log.info("Received Orders message -> {}", orderRequest);

        User user = userValidationService.validateAndGetUser(orderRequest.getUserId());
        Order order = orderProcessingService.createOrder(orderRequest, user);

        orderRepository.save(order);
        log.info("Order savbed: {}", order.getId());
    }
}
