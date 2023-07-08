package ru.titov.kafka.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.titov.kafka.producer.model.color.enums.Color;
import ru.titov.kafka.producer.model.size.Size;

import java.util.List;
import java.util.UUID;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:38
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Furniture {
    private UUID id;
    private Color color;
    private List<Size> sizes;
}
