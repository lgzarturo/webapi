package com.arthurolg.practices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat extends Animal implements FelineDomestic {
    private int age;
    private float weight;

    @Override
    public void meaw() {
        System.out.println("Meaw!!");
    }

    @Override
    public void hunting() {
        System.out.println("Shhhhhh!");
    }

    public void sleep() {
        System.out.println("El jaguar duerme");
    }

    public void eat() {
        System.out.println("El jaguar come");
    }
}
