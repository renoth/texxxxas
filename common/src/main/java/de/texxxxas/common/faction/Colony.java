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
}
