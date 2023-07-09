package ru.titov.kafka.common.model.dto;

import lombok.*;
import ru.titov.kafka.common.model.Furniture;

import java.util.UUID;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:37
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRqDto {
    @NonNull
    private Furniture furniture;
    private UUID workerId;
    private UUID customerId;
}
