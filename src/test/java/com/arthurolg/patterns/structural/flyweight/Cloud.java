package com.arthurolg.patterns.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cloud {
    private TypeCloud type;
    private int posX;
    private int posY;
}
