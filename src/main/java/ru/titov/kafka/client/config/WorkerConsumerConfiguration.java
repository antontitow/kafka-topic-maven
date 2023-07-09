package ru.titov.kafka.client.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import ru.titov.kafka.common.model.dto.WorkerRqDto;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 10.07.2023, 1:19
 **/
@Configuration
public class WorkerConsumerConfiguration {

    @Bean("workerConsumerFactory")
    public ConsumerFactory<WorkerRqDto, String> workerConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, WorkerRqDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        return new DefaultKafkaConsumerFactory<>(props);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<WorkerRqDto, String> workerKafkaListener() {
        ConcurrentKafkaListenerContainerFactory<WorkerRqDto, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(workerConsumerFactory());

        return factory;
    }
}
