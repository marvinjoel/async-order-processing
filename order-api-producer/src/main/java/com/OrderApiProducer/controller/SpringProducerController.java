package com.OrderApiProducer.controller;

import com.OrderApiProducer.dto.OrderRequest;
import com.OrderApiProducer.serviceRabbit.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class SpringProducerController {

    private final RabbitMQJsonProducer jsonProducer;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest order){
        jsonProducer.sendJsonMessage(order);
        return ResponseEntity.ok("Json message sent to RabbitMQ json ....");
    }
}
