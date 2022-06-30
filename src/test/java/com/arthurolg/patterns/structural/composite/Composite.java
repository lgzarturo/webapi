package com.arthurolg.patterns.structural.composite;

public class Composite {
    public static void main(String[] args) {
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("New");
        Menu menu3 = new Menu("Open");
        Menu menu4 = new Menu("Open with..");
        Menu menu5 = new Menu("Readonly");
        menu3.addMenu(menu4);
        menu3.addMenu(menu5);
        menu1.addMenu(menu2);
        menu1.addMenu(menu3);

        menu1.print();
        menu2.print();
        menu3.print();
        menu4.print();
        menu5.print();
    }
}
