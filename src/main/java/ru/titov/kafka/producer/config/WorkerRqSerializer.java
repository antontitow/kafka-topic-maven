package ru.titov.kafka.producer.config;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serializer;
import ru.titov.kafka.common.model.dto.WorkerRqDto;

import java.nio.charset.Charset;


/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 23:46
 **/
public class WorkerRqSerializer implements Serializer<WorkerRqDto> {
    private Gson gson = new Gson();

    @Override
    public byte[] serialize(String s, WorkerRqDto workerRqDto) {
        return gson.toJson(workerRqDto).getBytes(Charset.forName("UTF-8"));
    }

}
