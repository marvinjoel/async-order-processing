package com.OrderApiProducer.serviceRabbit;

import com.OrderApiProducer.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class RabbitMQJsonProducer {

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.orders.key}")
    private String routingOrdersKey;

    private final RabbitTemplate rabbitTemplate;

    public void sendJsonMessage(OrderRequest order){
        log.info("Json message sent -> {}", order.toString());
        rabbitTemplate.convertAndSend(exchange, routingOrdersKey, order);
    }
}
