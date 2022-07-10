package com.arthurolg.patterns.behaviour.memento;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private int tires;
    private int doors;
    private int cylinders;
    private String color;

    public Car getCar() {
        return new Car(this.tires, this.doors, this.cylinders, this.color);
    }

    public void reset(Car car) {
        this.setColor(car.color);
    }
}
