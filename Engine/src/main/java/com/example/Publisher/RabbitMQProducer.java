package com.example.Publisher;

import org.apache.avro.specific.SpecificRecord;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQProducer {

    @Value("${rabbitmq.gameOrdered_exchange.name}")
    private String OnOrderExchange;

    @Value("${rabbitmq.gameOrdered_routing_key.name}")
    private String onOrderRoutingKey;

    @Value("${rabbitmq.gameOrdered_queue.name}")
    private String onOrderQueue;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
    private RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(SpecificRecord event) {
        LOGGER.info(String.format("Message sent -> %s", event.toString()));
        if (event.getSchema().toString().equals("onOrderQueue")) {
            rabbitTemplate.convertAndSend(OnOrderExchange, onOrderRoutingKey, event);
        }
    }
}
