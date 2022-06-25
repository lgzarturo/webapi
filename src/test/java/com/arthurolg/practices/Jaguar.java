package com.arthurolg.practices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.transaction.NotSupportedException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jaguar extends Animal implements FelineSavage {
    private int age;
    private float weight;

    @Override
    public void roar() {
        System.out.println("Roooooaaaarrr!!");
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
