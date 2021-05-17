package com.kafka.boot.kafka.listener;

import com.google.gson.Gson;
import com.kafka.boot.kafka.service.BicycleService;
import com.kafka.boot.kafka.service.NewsService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    private NewsService newsService;

    @Autowired
    private BicycleService bicycleService;

    @KafkaListener(topics = "public.bicycle_rental_office_info", groupId = "public.bicycle_rental_office_info")
    public void consume(@Payload String message
                       ,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("partition id=[" + partition + "], message :: " + message);

        Gson gson = new Gson();

        // NewsVO로 형변환
//        NewsVO newsVO = gson.fromJson(message, NewsVO.class);
//
//        newsService.insertNews(newsVO);
    }

    @KafkaListener(topics = "public.bicycle_rental_office_info", groupId = "public.bicycle_rental_office_info9")
    public void bicycleConsumer(@Payload String message) {
        bicycleService.process(message);
    }
}
