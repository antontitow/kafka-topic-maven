package ru.titov.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:27
 **/
@Configuration
public class TopicConfig {
    @Bean
    public NewTopic topic() {

        return TopicBuilder.name("order")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
