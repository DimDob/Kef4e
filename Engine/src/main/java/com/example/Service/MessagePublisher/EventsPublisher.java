package com.example.Service.MessagePublisher;

import com.example.Entity.Game;
import com.example.Publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import schemas.messaging.avro.events.games.ordered.GameOrdered;

import java.util.Random;

@RequiredArgsConstructor
@Slf4j
@Component
public class EventsPublisher {

    private final RabbitMQProducer rabbitMQProducer;

    public void orderBook(Game game) { //build payload for ordered game
        float randomPrice = new Random().nextFloat() * 100;

        GameOrdered gameOrdered = GameOrdered.newBuilder()
                .setId(String.valueOf(game.getId()))
                .setTitle(game.getTitle())
                .setPrice(randomPrice)
                .build();
        rabbitMQProducer.sendMessage(gameOrdered);

    }
}
