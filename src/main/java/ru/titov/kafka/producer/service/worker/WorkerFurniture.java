package ru.titov.kafka.producer.service.worker;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 22:57
 **/
public interface WorkerFurniture {
    default String getTopic() {
        return "worker-furniture";
    }
}
