package com.products.Products.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String TOPIC_PRODUCTS = "products";

    public void producer(String message) {
        kafkaTemplate.send(TOPIC_PRODUCTS, message);
    }
}
