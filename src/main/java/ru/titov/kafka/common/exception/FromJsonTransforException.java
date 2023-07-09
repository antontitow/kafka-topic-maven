package ru.titov.kafka.common.exception;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 17:06
 **/
public class FromJsonTransforException extends Exception {
    public FromJsonTransforException() {
        super("FromJsonTransforException");
    }

    public FromJsonTransforException(String message) {
        super(message);
    }
}
