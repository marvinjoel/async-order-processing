package com.OrderProcessorConsumer.service;

import com.OrderProcessorConsumer.dto.OrderItems;
import com.OrderProcessorConsumer.dto.OrderRequest;
import com.OrderProcessorConsumer.model.Order;
import com.OrderProcessorConsumer.model.OrderItem;
import com.OrderProcessorConsumer.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProcessingService {

    public Order createOrder(OrderRequest orderRequest, User user){
        Order order = new Order();
        order.setPaymentMethod(orderRequest.getPaymentMethod());
        order.setUser(user);

        List<OrderItem> orderItems = new ArrayList<>();
        double totalAmount = 0;

        for (OrderItems itemDTO: orderRequest.getItems()){
            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setProductId(itemDTO.getProductId());
            orderItem.setProductName(itemDTO.getProductName());
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setUnitPrice(itemDTO.getUnitPrice());
            orderItem.setSubtotal(itemDTO.getQuantity() * itemDTO.getUnitPrice());
            orderItems.add(orderItem);
            totalAmount += orderItem.getSubtotal();
        }
        order.setItems(orderItems);
        order.setTotalAmount(totalAmount);
        return order;
    }
}
