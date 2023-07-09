package ru.titov.kafka.common.model.size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:56
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Size {
    private SizeType sizeType;
    private Double value;
}
