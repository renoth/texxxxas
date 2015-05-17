package de.texxxxas.generator;

import de.texxxxas.common.tech.Knowledge;
import de.texxxxas.common.tech.EconomyTechs;
import de.texxxxas.common.tech.Technology;

public class KnowledgeGenerator {
    public static Knowledge startKnowledge() {
        Knowledge k = new Knowledge();

        k.setEconomyTechs(new EconomyTechs());

        k.getEconomyTechs().setConstructionTech(new Technology("Construction Efficiency", 1000, false, 0));

        return k;
    }

    //TODO method where you can enter techpoints and get upgraded tech in return (for later starts)
}
