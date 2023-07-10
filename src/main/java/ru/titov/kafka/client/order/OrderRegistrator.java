package ru.titov.kafka.client.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.titov.kafka.common.util.JsonAdapterUtil;
import ru.titov.kafka.common.model.OrderRq;
import ru.titov.kafka.producer.service.order.OrderFurniture;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:53
 **/
@Component
@EnableKafka
@Slf4j
public class OrderRegistrator implements OrderFurniture {

    @KafkaListener(id = "order-consumer-group-id", topics = "order-furniture-last", groupId = "first-worker" )
    public void listen(String in) {
        log.info("order-furniture received data : ");

        try {
            OrderRq orderRqDto = JsonAdapterUtil.toObject(in, OrderRq.class);
            log.info("CustomerId: {}", orderRqDto.getCustomerId());

        } catch (Exception e) {
            log.info("throw error {}", e.getMessage());
        }
    }
}
