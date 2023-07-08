package ru.titov.kafka.producer.service;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:46
 **/
public interface OrderFurniture {
    default String getTopic() {
        return "ORDER-FURNITURE";
    }
}
