package de.texxxxas.common.tech;

//TODO set this as abstract and implement subclasses (EconomyTechGroup, WeaponTechGroup etc.)
public class EconomyTechs {
    private Technology constructionTech;

    public Technology getConstructionTech() {
        return constructionTech;
    }

    public void setConstructionTech(Technology constructionTech) {
        this.constructionTech = constructionTech;
    }
}
