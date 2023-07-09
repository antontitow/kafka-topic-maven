package ru.titov.kafka.common.model.color.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.titov.kafka.common.model.color.RgbColor;
import ru.titov.kafka.common.model.color.RgbaColor;

/**
 * @autor : Anton Titov {@literal antontitow@bk.ru}
 * @created : 08.07.2023, 22:39
 **/

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Color {

    WHITE("white", "white", new RgbColor(255, 255, 255), new RgbaColor(255, 255, 255, 1));

    private String name;
    private String description;
    private RgbColor rgbColor;
    private RgbaColor rgbaColor;


}
