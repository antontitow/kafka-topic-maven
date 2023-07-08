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
 * @created : 08.07.2023, 22:27
 **/
@Configuration
@ConfigurationProperties(prefix = "ru.titov.kafka")
@Getter
@Setter
public class TopicConfig {

    private String topic;

    @Bean
    public NewTopic topic() {

        return TopicBuilder.name(topic)
                .partitions(10)
                .replicas(1)
                .build();
    }
}
