package ru.titov.kafka.client.config;

import org.apache.kafka.common.serialization.Deserializer;
import ru.titov.kafka.common.model.dto.WorkerRqDto;
import ru.titov.kafka.common.util.JsonAdapterUtil;

import java.nio.charset.StandardCharsets;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 10.07.2023, 1:21
 **/
public class WorkerRqDeserializer implements Deserializer<WorkerRqDto> {

    @Override
    public WorkerRqDto deserialize(String s, byte[] bytes) {

        if (bytes == null) {
            return null;
        }

        return JsonAdapterUtil.toObject(new String(bytes, StandardCharsets.UTF_8), WorkerRqDto.class);
    }
}
