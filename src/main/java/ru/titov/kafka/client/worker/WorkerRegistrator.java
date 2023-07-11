package ru.titov.kafka.client.worker;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.DependsOn;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import ru.titov.kafka.common.model.dto.WorkerRqDto;
import ru.titov.kafka.producer.service.worker.WorkerFurniture;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 10.07.2023, 0:46
 **/
@Component
@EnableKafka
@Slf4j
public class WorkerRegistrator implements WorkerFurniture {
    @KafkaListener(id = "worker-consumer-group-id",
            topics = "worker-furniture",
            containerFactory = "workerKafkaListener",
            groupId = "first-worker"
    )
    public void listen(ConsumerRecord<WorkerRqDto, String> workerRqDto, Acknowledgment acknowledgment) {
        long offset = workerRqDto.offset();
        log.info("offset", offset);
        log.info("worker-furniture received data : ");

        try {
            log.info("WorkerId: {}", workerRqDto.key().getWorkerId());

            if (offset % 2 == 0) {
                throw new RuntimeException();
            }

            acknowledgment.acknowledge();
        } catch (RuntimeException runtimeException) {
            throw new RuntimeException();

        } catch (Exception e) {
            log.info("throw error {}", e.getMessage());
        }
    }

    @DltHandler
    public void processMessage(ConsumerRecord<WorkerRqDto, String> workerRqDto) {
        log.info("processMessage");
        log.info("workerRqDto", workerRqDto);
    }

}
