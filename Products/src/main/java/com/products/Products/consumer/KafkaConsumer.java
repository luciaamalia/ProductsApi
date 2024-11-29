package com.products.Products.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "products", groupId = "products_groupId")
    public void consume(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
