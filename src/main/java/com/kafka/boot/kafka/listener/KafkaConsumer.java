package com.kafka.boot.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test2", groupId = "lee")
    public void consume(@Payload String message) throws IOException {
        System.out.println(String.format("Consummer message :: %s", message));
    }
}
