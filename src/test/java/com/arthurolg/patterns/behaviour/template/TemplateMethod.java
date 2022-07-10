package com.arthurolg.patterns.behaviour.template;

public class TemplateMethod {
    public static void main(String[] args) {
        User admin = new Administrator();
        User manager = new Manager();
        admin.auth();
        admin.working();
        System.out.println("\n");
        manager.auth();
        manager.working();
    }
}
