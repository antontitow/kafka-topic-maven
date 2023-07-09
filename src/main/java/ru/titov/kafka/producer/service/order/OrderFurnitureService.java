package ru.titov.kafka.producer.service.order;

import org.springframework.http.ResponseEntity;
import ru.titov.kafka.common.model.Response;
import ru.titov.kafka.common.model.dto.OrderRqDto;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:03
 **/
public interface OrderFurnitureService {
    ResponseEntity<Response> createFurnitureOrder(OrderRqDto orderRqDto);
}
