package ru.titov.kafka.producer.service.worker;

import org.springframework.http.ResponseEntity;
import ru.titov.kafka.common.model.Response;
import ru.titov.kafka.common.model.dto.WorkerRqDto;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 10.07.2023, 0:09
 **/
public interface WorkerFurnitureService {
    ResponseEntity<Response> addWorker(WorkerRqDto workerRqDto);
}
