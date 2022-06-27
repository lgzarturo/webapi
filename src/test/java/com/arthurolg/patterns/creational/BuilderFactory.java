package com.arthurolg.patterns.creational;

public class BuilderFactory {
    public static void main(String[] args) {
        var person = Person.make("arturo", "lopez")
                .setHasContactData(true)
                .setPhone("998")
                .setEmail("arthurolg@gmail.com")
                .setAddress("Conocida")
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
    private boolean hasContactData;

    private Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.hasContactData = false;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BuilderPerson setHasContactData(boolean hasContactData) {
        if (!hasContactData) {
            throw new IllegalArgumentException("No se puede asignar falso");
        }
        this.hasContactData = true;
        return new BuilderPerson(this);
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

    public static class BuilderPerson {
        private Person person;
        public BuilderPerson(Person person) {
            this.person = person;
        }

        public BuilderPerson setEmail(String email) {
            this.person.email = email;
            return this;
        }

        public BuilderPerson setPhone(String phone) {
            this.person.phone = phone;
            return this;
        }

        public BuilderPerson setAddress(String address) {
            this.person.address = address;
            return this;
        }

        public Person build() {
            return this.person;
        }
    }
}
