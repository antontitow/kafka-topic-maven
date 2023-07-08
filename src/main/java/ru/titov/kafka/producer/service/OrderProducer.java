package ru.titov.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.titov.kafka.JsonAdapterUtil;
import ru.titov.kafka.producer.model.dto.OrderRqDto;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:33
 **/
@Service
@Primary
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class OrderProducer implements OrderFurniture {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows
    public void send(OrderRqDto orderRqDto) {
        log.info("send message to {} topic", getTopic());

        kafkaTemplate.send(getTopic(), JsonAdapterUtil.toJson(orderRqDto));
    }
}
