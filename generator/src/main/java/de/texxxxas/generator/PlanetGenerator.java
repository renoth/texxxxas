package de.texxxxas.generator;

import de.texxxxas.common.game.GameParameters;
import de.texxxxas.common.universe.StellarConstants;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PlanetGenerator {
    public static BigInteger generateMass(double randomGaussian) {
        return StellarConstants.EARTH_MASS.multiply(new BigDecimal(Math.max(GameParameters.getCurrentGameParameters().getMinPlanetMass(), (randomGaussian + 1d)))).toBigInteger();
    }
}
