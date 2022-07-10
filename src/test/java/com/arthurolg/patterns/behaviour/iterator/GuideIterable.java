package com.arthurolg.patterns.behaviour.iterator;

public class GuideIterable implements IterableInterface {

    private final PhoneGuide phoneGuide;
    private int positionIndex;

    public GuideIterable(PhoneGuide phoneGuide) {
        this.phoneGuide = phoneGuide;
    }

    @Override
    public String next() {
        return this.phoneGuide.getPhones().get(positionIndex++);
    }

    @Override
    public boolean hasNext() {
        return this.positionIndex < this.phoneGuide.getPhones().size()
                && this.phoneGuide.getPhones().get(this.positionIndex) != null;
    }
}
