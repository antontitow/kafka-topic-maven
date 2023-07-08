package ru.titov.kafka.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.titov.kafka.producer.model.Response;
import ru.titov.kafka.producer.model.dto.OrderRqDto;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 23:17
 **/
@Service
@Primary
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class OrderFurnitureServiceImpl implements OrderFurnitureService {
    private final OrderProducer orderProducer;

    @Override
    public ResponseEntity<Response> createFurnitureOrder(OrderRqDto orderRqDto) {

        orderProducer.send(orderRqDto);

        return ResponseEntity.ok()
                .body(Response.builder()
                        .status("SUCCESS")
                        .description("ORDER ADDED SUCCESSFULLY")
                        .build());

    }
}
