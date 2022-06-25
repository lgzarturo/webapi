package com.arthurolg.practices;

public class Presentation {
    public void print(Figure figure) {
        System.out.println("El area del "+figure.getClass().getSimpleName()+": "+figure+" es: "+figure.area());
    }
}
