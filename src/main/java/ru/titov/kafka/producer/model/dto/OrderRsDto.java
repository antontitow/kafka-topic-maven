package ru.titov.kafka.producer.model.dto;

import lombok.*;
import ru.titov.kafka.producer.model.Furniture;

import java.time.LocalDateTime;
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

    @NonNull
    private LocalDateTime orderTime;
    private LocalDateTime sheduleExecutionTime;
}
