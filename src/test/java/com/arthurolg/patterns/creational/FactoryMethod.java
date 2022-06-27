package com.arthurolg.patterns.creational;

public class FactoryMethod {
    public static void main(String[] args) {
        var sandwich = new ClubSandwichService();
        var onionSandwich = sandwich.createClubSandwich("Onion");
        System.out.println(onionSandwich);
        var specialSandwich = sandwich.createClubSandwich("Special");
        System.out.println(specialSandwich);
    }
}

class ClubSandwichService implements ClubSandwichFactory {
    @Override
    public Sandwich createClubSandwich(String bread) {
        return switch (bread) {
            case "Garlic" -> new Sandwich(1, 2, "Garlic");
            case "Onion" -> new Sandwich(1, 2, "Onion");
            case "Special" -> new SpecialSandwich(3, 3);
            default -> null;
        };
    }
}

interface ClubSandwichFactory {
    Sandwich createClubSandwich(String bread);
}

class Sandwich {
    private final int cheeseSlices;
    private final int hamSlices;
    private final String bread;

    public Sandwich(int cheeseSlices, int hamSlices, String breadType) {
        this.cheeseSlices = cheeseSlices;
        this.hamSlices = hamSlices;
        this.bread = breadType;
    }

    @Override
    public String toString() {
        return "Sandwich {" +
                "cheeseSlices=" + cheeseSlices +
                ", hamSlices=" + hamSlices +
                ", bread='" + bread + '\'' +
                '}';
    }
}

class SpecialSandwich extends Sandwich {

    public SpecialSandwich(int cheeseSlices, int hamSlices) {
        super(cheeseSlices, hamSlices, "Special");
    }
}
