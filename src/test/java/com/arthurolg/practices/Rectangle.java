package com.arthurolg.practices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rectangle implements Figure {
    private Integer base;
    private Integer height;

    public float area() {
        return this.base * this.height;
    }
}
