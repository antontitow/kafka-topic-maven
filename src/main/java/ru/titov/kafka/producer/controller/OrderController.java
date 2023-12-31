package ru.titov.kafka.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.kafka.common.model.Response;
import ru.titov.kafka.common.model.dto.OrderRqDto;
import ru.titov.kafka.producer.service.order.OrderFurnitureService;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:34
 **/
@RestController
@RequestMapping("v1/order/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderController {
    private final OrderFurnitureService orderFurnitureService;

    @PostMapping("add")
    public ResponseEntity<Response> createFurnitureOrder(@RequestBody OrderRqDto orderRqDto) {
        return orderFurnitureService.createFurnitureOrder(orderRqDto);
    }
}
