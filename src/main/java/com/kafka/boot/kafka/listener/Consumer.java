package com.kafka.boot.kafka.listener;

import com.google.gson.Gson;
import com.kafka.boot.kafka.service.NewsService;
import com.kafka.boot.kafka.vo.NewsVO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Service
public class Consumer {

    @Autowired
    private NewsService newsService;

    private KafkaConsumer<String, String> consumer = null;

    @PostConstruct
    public void build() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "lee");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumer = new KafkaConsumer<>(properties);
    }

    @KafkaListener(topics = "test", groupId = "lee")
    public void consume(@Payload String message
                       ,@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        System.out.println("partition id=[" + partition + "], message :: " + message);

        Gson gson = new Gson();

        // NewsVO로 형변환
        NewsVO newsVO = gson.fromJson(message, NewsVO.class);

        System.out.println("contents id --> " + newsVO.getContents_id());
        System.out.println("domain --> " + newsVO.getDomain());
        System.out.println("category_nm --> " + newsVO.getCategory_nm());
        System.out.println("title --> " + newsVO.getTitle());

        newsService.insertNews(newsVO);
    }
}
