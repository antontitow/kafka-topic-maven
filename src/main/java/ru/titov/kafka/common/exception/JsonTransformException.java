package ru.titov.kafka.common.exception;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:39
 **/

public class JsonTransformException extends Exception {
    public JsonTransformException() {
        super("JsonTransformException");
    }

    public JsonTransformException(String message) {
        super(message);
    }
}
