package com.products.Products.producers;

import com.products.Products.dtos.RequestProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, RequestProductDTO> kafkaTemplate;

    private final String TOPIC_PRODUCTS = "products";

    public void producer(RequestProductDTO product) {
        kafkaTemplate.send(TOPIC_PRODUCTS, product);
    }
}
