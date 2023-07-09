package ru.titov.kafka.topic;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 23:06
 **/
@Configuration
@ConfigurationProperties(prefix = "ru.titov.kafka.worker")
@Getter
@Setter
public class WorkerTopicConfig {
    private String topic;

    @Bean
    public NewTopic workerTopic() {

        return TopicBuilder.name(topic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
