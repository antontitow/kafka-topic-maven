package ru.titov.kafka.producer.model.color;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:46
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RgbColor {
    private int red;
    private int green;
    private int blue;
}
