package de.texxxxas.common;

import de.texxxxas.common.faction.Faction;
import de.texxxxas.common.universe.Universe;

import java.util.Date;
import java.util.List;

public class TexxxxasGame {
    private List<Faction> factions;
    private Universe universe;
    private Date starDate;

    public Date getStarDate() {
        return starDate;
    }

    public void setStarDate(Date starDate) {
        this.starDate = starDate;
    }

    public Universe getUniverse() {
        return universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public void setFactions(List<Faction> factions) {
        this.factions = factions;
    }
}
