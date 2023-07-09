package ru.titov.kafka.common.service;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 10.07.2023, 0:12
 **/
public interface FurnitureSender<T> {
    void send(T t);
}
