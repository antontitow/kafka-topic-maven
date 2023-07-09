package ru.titov.kafka.common.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 22:59
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkerRqDto implements Serializable {
    @NonNull
    private UUID workerId;
    private String name;
    private String surname;
}
