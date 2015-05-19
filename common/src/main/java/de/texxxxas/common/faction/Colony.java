package de.texxxxas.common.faction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.texxxxas.common.universe.Colonizable;
import de.texxxxas.common.universe.Planet;

public class Colony {
    @JsonManagedReference
    private Colonizable location;

    @JsonIgnore
    private Faction owner;

    private long population;
    private double constructionFactory;

    public Colony(Faction player, Planet location) {
        this.owner = player;
        this.location = location;
    }

    public Colonizable getLocation() {
        return location;
    }

    public void setLocation(Colonizable location) {
        this.location = location;
    }

    public Faction getOwner() {
        return owner;
    }

    public void setOwner(Faction owner) {
        this.owner = owner;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public double getConstructionFactory() {
        return constructionFactory;
    }

    public void setConstructionFactory(double constructionFactory) {
        this.constructionFactory = constructionFactory;
    }
}
