package com.products.Products.producers;

import com.products.Products.dtos.RequestProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private final String TOPIC_PRODUCTS = "products";

    //qualquer micro que tiver definido esse topico vai receber a mensagem.
    public void producer(String product) {
        kafkaTemplate.send(TOPIC_PRODUCTS, product);
    }
}
