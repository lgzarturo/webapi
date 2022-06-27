package com.arthurolg.patterns.creational;

public class BuilderFactory {
    public static void main(String[] args) {
        var person = Person.make("arturo", "lopez")
                .setAddress("Conocida")
                .setPhone("998")
                .setEmail("arthurolg@gmail.com")
                .build();
        System.out.println(person);
    }
}

class Person {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    private Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static Person make(String name, String lastName) {
        return new Person(name, lastName);
    }

    public Person build() {
        return this;
    }
}
