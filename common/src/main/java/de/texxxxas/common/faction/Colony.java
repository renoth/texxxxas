package de.texxxxas.common.faction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.texxxxas.common.universe.Colonizable;

public class Colony {
    @JsonIgnore
    private Colonizable location;
    @JsonIgnore
    private Faction owner;

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
