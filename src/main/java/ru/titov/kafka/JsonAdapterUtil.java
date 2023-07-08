package ru.titov.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import ru.titov.kafka.producer.exception.JsonTransformException;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:36
 **/
public final class JsonAdapterUtil {

    @SneakyThrows
    public static <T> String toJson(T object) {
        try {
            Gson gson = new GsonBuilder().create();

            return gson.toJson(object);
        } catch (Exception exception) {
            throw new JsonTransformException();
        }
    }
}
