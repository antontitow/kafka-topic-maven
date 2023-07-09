package ru.titov.kafka.common.model.dto;

import lombok.*;
import ru.titov.kafka.common.model.Furniture;

import java.util.UUID;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 23:58
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRsDto {
    private UUID orderId;
    private Double cost;

    @NonNull
    private Furniture furniture;
    private UUID workerId;
    private UUID customerId;
}
