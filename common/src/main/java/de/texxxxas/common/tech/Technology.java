package de.texxxxas.common.tech;

public class Technology {
    private String name;
    private long baseCost;
    private boolean exponentialCost;

    private double techLevel;

    public Technology(String name, long baseCost, boolean exponentialCost, double techLevel) {
        this.name = name;
        this.baseCost = baseCost;
        this.exponentialCost = exponentialCost;
        this.techLevel = techLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(long baseCost) {
        this.baseCost = baseCost;
    }

    public boolean isExponentialCost() {
        return exponentialCost;
    }

    public void setExponentialCost(boolean exponentialCost) {
        this.exponentialCost = exponentialCost;
    }

    public double getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(double techLevel) {
        this.techLevel = techLevel;
    }
}
