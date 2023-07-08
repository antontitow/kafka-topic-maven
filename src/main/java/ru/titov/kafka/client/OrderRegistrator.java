package ru.titov.kafka.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.titov.kafka.producer.service.OrderFurniture;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:53
 **/
@Component
@EnableKafka
@Slf4j
public class OrderRegistrator implements OrderFurniture {

    @KafkaListener(id = "myId", topics = "order-furniture")
    public void listen(String in) {
        log.info(in);
    }

}
