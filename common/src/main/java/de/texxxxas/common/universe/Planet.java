package de.texxxxas.common.universe;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.texxxxas.common.faction.Faction;

public class Planet extends CelestialBody implements Colonizable {
    @JsonBackReference
    private Star star;
    //@JsonBackReference (no factions yet)
    private Faction owner;

    private Long orbitalDistance;

    public Planet(Star star) {
        this.star = star;
    }

    @Override
    public Faction getOwner() {
        return owner;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public void setOwner(Faction owner) {
        this.owner = owner;
    }

    public Long getOrbitalDistance() {
        return orbitalDistance;
    }

    public void setOrbitalDistance(Long orbitalDistance) {
        this.orbitalDistance = orbitalDistance;
    }
}
