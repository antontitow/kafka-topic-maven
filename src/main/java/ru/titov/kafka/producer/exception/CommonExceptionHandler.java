package ru.titov.kafka.producer.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.titov.kafka.producer.model.Response;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:24
 **/
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(OrderFurnitureCreateException.class)
    @ResponseBody
    public ResponseEntity<Response> orderFurnitureCreateExceptionHandler(OrderFurnitureCreateException exception) {
        return ResponseEntity.ok().body(Response.builder().status("ERROR").description("CREATION ORDER ERROR").build());
    }

    @ExceptionHandler(JsonTransformException.class)
    @ResponseBody
    public ResponseEntity<Response> orderJsonTransformExceptionHandler(JsonTransformException exception) {
        return ResponseEntity.ok().body(Response.builder().status("ERROR").description("Json transformation exception").build());
    }
}
