package ru.titov.kafka.producer.service.worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.titov.kafka.common.service.FurnitureSender;
import ru.titov.kafka.common.model.Response;
import ru.titov.kafka.common.model.dto.WorkerRqDto;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 10.07.2023, 0:11
 **/
@Service
@Primary
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class WorkerFurnitureServiceImpl implements WorkerFurnitureService {
    private final FurnitureSender<WorkerRqDto> sender;

    @Override
    public ResponseEntity<Response> addWorker(WorkerRqDto workerRqDto) {
        sender.send(workerRqDto);

        return ResponseEntity.ok()
                .body(Response.builder()
                        .status("SUCCESS")
                        .description("WORKER ADDING...")
                        .build());
    }
}
