package ru.titov.kafka.producer.config;

import org.apache.kafka.clients.producer.internals.DefaultPartitioner;
import org.apache.kafka.common.Cluster;
import ru.titov.kafka.common.model.dto.WorkerRqDto;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 23:59
 **/
public class WorkerPartitioner extends DefaultPartitioner {

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        Object newKey = null;

        if (key != null) {
            WorkerRqDto workerRqDto = (WorkerRqDto) key;
            newKey = workerRqDto.getWorkerId().toString();
            keyBytes = ((String) newKey).getBytes();
        }

        return super.partition(topic, key, keyBytes, value, valueBytes, cluster);
    }
}
