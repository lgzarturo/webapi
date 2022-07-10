package com.arthurolg.patterns.structural.flyweight;

import java.util.HashMap;

public class CloudFactory {
    private final HashMap<TypeCloud, Cloud> cloudHashMap;

    public CloudFactory() {
        this.cloudHashMap = new HashMap<>();
    }

    public Cloud getCloud(TypeCloud typeCloud) {
        Cloud cloud = this.cloudHashMap.get(typeCloud);
        if (cloud == null) {
            cloud = new Cloud(typeCloud, 100,100);
            this.cloudHashMap.put(typeCloud, cloud);
        }
        return cloud;
    }

    public int countClouds() {
        return this.cloudHashMap.size();
    }
}
