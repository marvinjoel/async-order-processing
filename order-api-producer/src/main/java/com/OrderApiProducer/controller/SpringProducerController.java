package com.OrderApiProducer.controller;

import com.OrderApiProducer.dto.OrderRequest;
import com.OrderApiProducer.serviceRabbit.RabbitMQJsonProducer;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "Orders Producer", description = "API para crear y enviar órdenes a través de RabbitMQ")
public class SpringProducerController {

    private final RabbitMQJsonProducer jsonProducer;

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest order){
        jsonProducer.sendJsonMessage(order);
        return ResponseEntity.ok("Json message sent to RabbitMQ json ....");
    }
}
