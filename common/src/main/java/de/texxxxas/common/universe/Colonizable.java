package de.texxxxas.common.universe;

import de.texxxxas.common.faction.Faction;

public interface Colonizable {

    //TODO maybe allow multipolar ownership later

    public Faction getOwner();
}
