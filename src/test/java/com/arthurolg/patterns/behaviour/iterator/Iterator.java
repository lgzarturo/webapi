package com.arthurolg.patterns.behaviour.iterator;

public class Iterator {
    public static void main(String[] args) {
        PhoneGuide guide = new PhoneGuide();
        guide.add("998181717181");
        guide.add("998819191919");
        guide.add("998736272828");
        guide.add("998715418299");
        guide.add("998614618289");
        IterableInterface iterable = new GuideIterable(guide);
        while (iterable.hasNext()) {
            System.out.println(iterable.next());
        }
    }
}
