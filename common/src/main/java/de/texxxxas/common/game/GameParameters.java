package de.texxxxas.common.game;

public class GameParameters {
    private static GameParameters currentParameters;
    //Universe
    private int universeSize;

    //Stars
    private int starCount;

    //Planets
    private int minPlanetsPerStar, maxPlanetsPerStar;
    private double minPlanetMass, maxPlanetMass; //as multiples of earth mass
    private double minPlanetDensity, maxPlanetDensity; //[kg/m^3]

    //Moons
    private int moonPercentage; //how likely a moon is (every successful roll nets another roll) beyond the min amount of moons
    private double minMoonsPerPlanet, maxMoonsPerPlanet; //min max amount of moons per planet
    private double minMoonPlanetMass, maxMoonPlanetMass; //how heavy a moon can get compared to planet (multiples of planet)

    //TODO find a mechanism for large planets to have more moons

    //Asteroids

    //TODO find a way to describe asteroid belts (maybe asteroid belts need a large gap in planet orbits)

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public int getUniverseSize() {
        return universeSize;
    }

    public void setUniverseSize(int universeSize) {
        this.universeSize = universeSize;
    }

    public int getMinPlanetsPerStar() {
        return minPlanetsPerStar;
    }

    public void setMinPlanetsPerStar(int minPlanetsPerStar) {
        this.minPlanetsPerStar = minPlanetsPerStar;
    }

    public int getMaxPlanetsPerStar() {
        return maxPlanetsPerStar;
    }

    public void setMaxPlanetsPerStar(int maxPlanetsPerStar) {
        this.maxPlanetsPerStar = maxPlanetsPerStar;
    }

    public double getMinPlanetMass() {
        return minPlanetMass;
    }

    public void setMinPlanetMass(double minPlanetMass) {
        this.minPlanetMass = minPlanetMass;
    }

    public double getMaxPlanetMass() {
        return maxPlanetMass;
    }

    public void setMaxPlanetMass(double maxPlanetMass) {
        this.maxPlanetMass = maxPlanetMass;
    }

    public int getMoonPercentage() {
        return moonPercentage;
    }

    public void setMoonPercentage(int moonPercentage) {
        this.moonPercentage = moonPercentage;
    }

    public double getMinMoonsPerPlanet() {
        return minMoonsPerPlanet;
    }

    public void setMinMoonsPerPlanet(double minMoonsPerPlanet) {
        this.minMoonsPerPlanet = minMoonsPerPlanet;
    }

    public double getMaxMoonsPerPlanet() {
        return maxMoonsPerPlanet;
    }

    public void setMaxMoonsPerPlanet(double maxMoonsPerPlanet) {
        this.maxMoonsPerPlanet = maxMoonsPerPlanet;
    }

    public double getMinMoonPlanetMass() {
        return minMoonPlanetMass;
    }

    public void setMinMoonPlanetMass(double minMoonPlanetMass) {
        this.minMoonPlanetMass = minMoonPlanetMass;
    }

    public double getMaxMoonPlanetMass() {
        return maxMoonPlanetMass;
    }

    public void setMaxMoonPlanetMass(double maxMoonPlanetMass) {
        this.maxMoonPlanetMass = maxMoonPlanetMass;
    }

    public static GameParameters getCurrentGameParameters() {
        if (currentParameters == null) {
            currentParameters = new GameParameters();

            currentParameters.starCount = 10;
            currentParameters.universeSize = 100;

            currentParameters.minPlanetsPerStar = 1;
            currentParameters.maxPlanetsPerStar = 5;
            currentParameters.minPlanetMass = 0.1;
            currentParameters.maxPlanetMass = 100;
            currentParameters.minPlanetDensity = 1000;
            currentParameters.maxPlanetDensity = 7000;

            currentParameters.minMoonsPerPlanet = 1;
            currentParameters.maxMoonsPerPlanet = 3;
            currentParameters.moonPercentage = 50;
            currentParameters.minMoonPlanetMass = 0.001;
            currentParameters.maxMoonPlanetMass = 0.7;
        }

        return currentParameters;
    }
}
