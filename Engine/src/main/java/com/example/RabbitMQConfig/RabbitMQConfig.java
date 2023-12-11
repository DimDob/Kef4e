package com.example.RabbitMQConfig;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.gameOrdered_queue.name}")
    private String gameOrderedQueue;

    @Value("${rabbitmq.gameOrdered_exchange.name}")
    private String gameOrderedExchange;

    @Value("${rabbitmq.gameOrdered_routing_key.name}")
    private String gameOrderedRoutingKey;

    @Bean
    public Queue onOrderQueue(){
        return new Queue(gameOrderedQueue);
    }

    @Bean
    public TopicExchange onOrderExchange() {
        return new TopicExchange(gameOrderedExchange);
    }

    //binding between queue and exchange using routing_key for ordering book
    @Bean
    public Binding onOrderBinding() {
        return BindingBuilder
                .bind(onOrderQueue())
                .to(onOrderExchange())
                .with(gameOrderedRoutingKey);
    }
}
