package com.OrderProcessorConsumer.configRabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.orders.name}")
    private String ordersQueueName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing.orders.key}")
    private String routingOrdersKey;

    @Bean
    public Queue ordersQueue(){
        return new Queue(ordersQueueName, true);
    }

    @Bean
    public TopicExchange ordersExchange(){
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Binding ordersBinding(Queue ordersQueue, TopicExchange ordersExchange){
        return BindingBuilder.bind(ordersQueue)
                .to(ordersExchange)
                .with(routingOrdersKey);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
