package com.kafka.boot.kafka.controller;

import com.kafka.boot.kafka.NaverNewsDto;
import com.kafka.boot.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final KafkaProducer producer;

    @Autowired
    KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendMessage(@RequestBody String message) {
        this.producer.sendMessage(message);

        return "success";
    }
}