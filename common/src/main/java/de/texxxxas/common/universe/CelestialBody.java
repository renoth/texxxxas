package de.texxxxas.common.universe;

import de.texxxxas.common.math.Coordinates;

import java.math.BigInteger;

public class CelestialBody implements Identifiable {
    private BigInteger mass;
    private Coordinates coordinates;

    private String id;

    public BigInteger getMass() {
        return mass;
    }

    public void setMass(BigInteger mass) {
        this.mass = mass;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String getIdentifier() {
        return id;
    }

    public void setIdentifier(String id) {
        this.id = id;
    }
}
