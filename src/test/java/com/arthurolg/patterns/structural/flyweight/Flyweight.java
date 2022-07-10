package com.arthurolg.patterns.structural.flyweight;

public class Flyweight {
    public static void main(String[] args) {
        CloudFactory cloudFactory = new CloudFactory();

        for (int i = 0; i < 100; i ++) {
            Cloud cloud = cloudFactory.getCloud(TypeCloud.SMALL);
        }

        for (int i = 0; i < 200; i ++) {
            Cloud cloud = cloudFactory.getCloud(TypeCloud.NORMAL);
        }

        for (int i = 0; i < 300; i ++) {
            Cloud cloud = cloudFactory.getCloud(TypeCloud.BIG);
        }

        System.out.println("Tamaño de elementos "+cloudFactory.countClouds());
    }
}
