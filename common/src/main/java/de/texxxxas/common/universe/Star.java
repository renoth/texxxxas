package de.texxxxas.common.universe;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

public class Star extends CelestialBody {
    @JsonManagedReference
    private List<Planet> planets;

    public Star() {
        planets = new ArrayList<>();
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
