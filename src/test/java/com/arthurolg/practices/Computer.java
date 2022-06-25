package com.arthurolg.practices;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Computer {
    private Peripheral mouse;
    private Peripheral keyboard;

    public void startUp() {
        mouse.connect();
        keyboard.connect();
    }
}
