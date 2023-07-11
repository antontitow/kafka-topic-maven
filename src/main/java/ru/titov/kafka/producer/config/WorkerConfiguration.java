package ru.titov.kafka.producer.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.retrytopic.RetryTopicConfiguration;
import org.springframework.kafka.retrytopic.RetryTopicConfigurationBuilder;
import ru.titov.kafka.common.model.dto.WorkerRqDto;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 23:17
 **/
@Configuration
public class WorkerConfiguration {

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, WorkerRqSerializer.class);
        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, WorkerPartitioner.class);

        return props;
    }

    @Bean
    public ProducerFactory<WorkerRqDto, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean("workerKafkaTemplate")
    public KafkaTemplate<WorkerRqDto, String> kafkaWorkerTemplate() {
        return new KafkaTemplate<WorkerRqDto, String>(producerFactory());
    }

}
