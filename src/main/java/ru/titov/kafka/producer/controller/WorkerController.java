package ru.titov.kafka.producer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.titov.kafka.common.model.Response;
import ru.titov.kafka.common.model.dto.WorkerRqDto;
import ru.titov.kafka.producer.service.worker.WorkerFurnitureService;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 23:08
 **/
@RestController
@RequestMapping("v1/worker/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class WorkerController {
    private final WorkerFurnitureService workerFurnitureService;

    @PostMapping("add")
    public ResponseEntity<Response> addWorker(@RequestBody WorkerRqDto workerRqDto) {
        return workerFurnitureService.addWorker(workerRqDto);
    }
}
