package ru.titov.kafka.client.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;
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
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        return new DefaultKafkaConsumerFactory<>(props);

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<WorkerRqDto, String> workerKafkaListener() {
        ConcurrentKafkaListenerContainerFactory<WorkerRqDto, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(workerConsumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setCommonErrorHandler(validationErrorHandler());


        return factory;
    }

    /**
     * After 2 trie works
     *
     * @return
     */
    @Bean
    public DefaultErrorHandler validationErrorHandler() {
        return new DefaultErrorHandler((record, exception) -> {
            System.out.println("record");
            System.out.println(record);
            System.out.println("exception");
            System.out.println(exception);
        }, new FixedBackOff(0L, 2L));
    }
}
