package ru.titov.kafka.producer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 10.07.2023, 0:44
 **/
@Configuration
public class OrderConfiguration {

    @Bean
    public ProducerFactory<String, String> orderProducerFactory() {
        return new DefaultKafkaProducerFactory<>(orderProducerConfigs());
    }

    @Bean
    public Map<String, Object> orderProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

    @Bean("orderKafkaTemplate")
    public KafkaTemplate<String, String> orderKafkaTemplate() {
        return new KafkaTemplate<String, String>(orderProducerFactory());
    }
}
