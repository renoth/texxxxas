package de.texxxxas.common.faction;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.texxxxas.common.tech.Knowledge;
import de.texxxxas.common.universe.Colonizable;

import java.util.List;

public class Faction {
    private String name;

    @JsonManagedReference
    private Colonizable homeworld;

    private List<Colony> colonies;

    private Knowledge knowledge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Colonizable getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(Colonizable homeworld) {
        this.homeworld = homeworld;
    }

    public List<Colony> getColonies() {
        return colonies;
    }

    public void setColonies(List<Colony> colonies) {
        this.colonies = colonies;
    }

    public Knowledge getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(Knowledge knowledge) {
        this.knowledge = knowledge;
    }
}
