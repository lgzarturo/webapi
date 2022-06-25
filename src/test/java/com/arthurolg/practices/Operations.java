package com.arthurolg.practices;

import javax.transaction.NotSupportedException;

public class Operations {
    public static void multiplications() {
        for (int i = 1; i<=10; i++) {
            System.out.printf("Tabla de multiplicar del %s\n", i);
            for (int j=1; j<=10; j++) {
                System.out.printf("%s x %s = %s\n", i, j, i*j);
            }
        }
    }

    public static void main(String[] args) throws NotSupportedException {
        Jaguar jaguar = new Jaguar();
        jaguar.setAge(2);
        jaguar.setWeight(30);
        System.out.println(jaguar);
        jaguar.sleep();
        jaguar.eat();
        jaguar.roar();
        FelineDomestic littleJaguar = new Cat(1, 10);
        System.out.println(littleJaguar);
        littleJaguar.hunting();
        littleJaguar.meaw();
        Figure rectangle = new Rectangle(10, 20);
        Figure triangle = new Triangle(10, 20);
        Presentation presentation = new Presentation();
        presentation.print(rectangle);
        presentation.print(triangle);
        Computer computer = new Computer(new Mouse(), new Keyboard());
        computer.startUp();
        // multiplications();
    }
}
