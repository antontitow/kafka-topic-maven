package ru.titov.kafka.producer.service.order;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.titov.kafka.common.util.JsonAdapterUtil;
import ru.titov.kafka.common.service.FurnitureSender;
import ru.titov.kafka.common.model.dto.OrderRqDto;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:33
 **/
@Service
@Primary
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class OrderProducer implements OrderFurniture, FurnitureSender<OrderRqDto> {

    private final @Qualifier("orderKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate;

    @SneakyThrows
    public void send(OrderRqDto orderRqDto) {
        log.info("send message to {} topic", getTopic());

        kafkaTemplate.send(getTopic(), JsonAdapterUtil.toJson(orderRqDto));
    }
}
