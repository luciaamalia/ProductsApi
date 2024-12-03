package com.users.Users.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.users.Users.dtos.ResponseProductsDTO;
import com.users.Users.repositories.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    private UserProductRepository userProductRepository;

    @KafkaListener(topics = "products", groupId = "products_groupId")
    public void consume(String message) {
       try{
           System.out.println("Mensagem recebida no tópico 'products': " + message);

//           ObjectMapper objectMapper = new ObjectMapper();
//           ResponseProductsDTO productModel = objectMapper.readValue(message, ResponseProductsDTO.class);

           userProductRepository.save(message);

        System.out.println("Produto salvo no banco: " + productModel);
        } catch (
    JsonProcessingException e) {
        System.err.println("Erro ao processar a mensagem JSON: " + e.getMessage());
    }

    }
}
