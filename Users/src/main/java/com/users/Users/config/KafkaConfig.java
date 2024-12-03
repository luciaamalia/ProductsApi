package com.users.Users.config;

import com.users.Users.dtos.ResponseProductsDTO;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    public DefaultKafkaConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");  // Permite desserializar qualquer pacote
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ResponseProductsDTO.class);  // Definindo o tipo do objeto a ser desserializado
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "users_consumer"); // Defina o grupo do consumidor
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // Começa a consumir desde o início, caso necessário

        return new DefaultKafkaConsumerFactory<>(props);
    }

}
