package ru.titov.kafka.common.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 09.07.2023, 0:07
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {
    private String description;
    private String status;
}
