package ru.titov.kafka.producer.service.worker;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.titov.kafka.common.model.dto.WorkerRqDto;
import ru.titov.kafka.common.service.FurnitureSender;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 22:56
 **/
@Service
@Primary
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class WorkerProducer implements WorkerFurniture, FurnitureSender<WorkerRqDto> {

    private final @Qualifier("workerKafkaTemplate") KafkaTemplate<WorkerRqDto, String> kafkaTemplate;

    @SneakyThrows
    @Override
    public void send(WorkerRqDto workerRqDto) {
        log.info("send message to {} topic", getTopic());

        kafkaTemplate.send(getTopic(), workerRqDto, workerRqDto.getName());
    }

}
