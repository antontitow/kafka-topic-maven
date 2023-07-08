package ru.titov.kafka.producer.model.color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RgbaColor extends RgbColor {
    private int alpha;

    public RgbaColor(int red, int green, int blue, int alpha) {
        super(red, green, blue);
        this.alpha = alpha;
    }
}
