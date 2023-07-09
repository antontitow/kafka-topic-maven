package ru.titov.kafka.common.model;

import lombok.*;

import java.util.UUID;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 17:11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRq {
    private UUID orderId;
    private Double cost;

    @NonNull
    private Furniture furniture;

    private UUID workerId;

    @org.springframework.lang.NonNull
    private UUID customerId;
}
