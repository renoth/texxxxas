package de.texxxxas.common.universe;

import java.util.LinkedHashMap;

public class Universe {
    private int size;
    private LinkedHashMap<String, Star> stars;

    public Universe() {
        stars = new LinkedHashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedHashMap<String, Star> getStars() {
        return stars;
    }

    public void setStars(LinkedHashMap<String, Star> stars) {
        this.stars = stars;
    }
}
