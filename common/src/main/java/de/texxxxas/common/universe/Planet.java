package de.texxxxas.common.universe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.texxxxas.common.faction.Colony;

public class Planet extends CelestialBody implements Colonizable {
    @JsonBackReference
    private Star star;
    //@JsonBackReference (no factions yet)
    private Colony colony;

    private Long orbitalDistance;

    public Planet(Star star) {
        this.star = star;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Long getOrbitalDistance() {
        return orbitalDistance;
    }

    public void setOrbitalDistance(Long orbitalDistance) {
        this.orbitalDistance = orbitalDistance;
    }

    @Override
    public Colony getColony() {
        return colony;
    }

    public void setColony(Colony colony) {
        this.colony = colony;
    }
}
