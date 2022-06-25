package com.arthurolg.practices;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Triangle implements Figure {
    private Integer base;
    private Integer height;

    public float area() {
        return Integer.valueOf((this.base * this.height) / 2).floatValue();
    }
}
