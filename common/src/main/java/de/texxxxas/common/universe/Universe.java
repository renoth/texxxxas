package de.texxxxas.common.universe;

import java.util.HashMap;

public class Universe {
    private int size;
    private HashMap<String, Star> stars;

    public Universe() {
        stars = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashMap<String, Star> getStars() {
        return stars;
    }

    public void setStars(HashMap<String, Star> stars) {
        this.stars = stars;
    }
}
