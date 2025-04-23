package com.OrderApiProducer.dto;

import lombok.Data;

@Data
public class OrderItems {
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
}
