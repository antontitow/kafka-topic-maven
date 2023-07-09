package ru.titov.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ru.titov.kafka.producer.exception.FromJsonTransforException;
import ru.titov.kafka.producer.exception.JsonTransformException;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:36
 **/
@Slf4j
public final class JsonAdapterUtil {

    @SneakyThrows
    public static <T> String toJson(T object) {
        try {
            log.info("object for serialization {}", object.toString());
            Gson gson = new GsonBuilder().create();

            return gson.toJson(object);
        } catch (Exception exception) {
            throw new JsonTransformException(exception.getMessage());
        }
    }

    @SneakyThrows
    public static <T> T toObject(String dto, Class<?> className) {
        try {
            return (T) new Gson().fromJson(dto, className);
        }catch (Exception e){
            throw new FromJsonTransforException(e.getMessage());
        }
    }
}
