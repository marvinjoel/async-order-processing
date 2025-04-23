package com.OrderApiProducer.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long userId;
    private List<OrderItems> items;
    private String paymentMethod;
}
