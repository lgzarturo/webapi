package com.arthurolg.patterns.structural.composite;

import java.util.ArrayList;

public class Menu implements MenuInterface {

    private final String title;
    private final ArrayList<MenuInterface> menus;

    public Menu(String title) {
        this.title = title;
        this.menus = new ArrayList<>();
    }

    @Override
    public boolean open() {
        System.out.println("Open! " + this.title);
        return true;
    }

    @Override
    public boolean close() {
        System.out.println("Close!" + this.title);
        return true;
    }

    public void addMenu(MenuInterface menu) {
        this.menus.add(menu);
    }

    public MenuInterface getMenu(int pos) {
        return this.menus.get(pos);
    }

    public void print() {
        System.out.println("-> Menu " + this.title);
        for (MenuInterface menu: this.menus) {
            menu.open();
        }
    }
}
