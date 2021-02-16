package com.kafka.boot.kafka.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "lee")
    public void consume(String message) throws IOException {
        System.out.println(String.format("Consummer message :: %s", message));
    }
}
