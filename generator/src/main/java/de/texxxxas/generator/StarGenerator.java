package de.texxxxas.generator;

import de.texxxxas.common.universe.StellarConstants;

import java.math.BigDecimal;
import java.util.Random;

public class StarGenerator {

    private static Random random = new Random();

    public static BigDecimal generateMass() {
        return StellarConstants.SUN_MASS.multiply(new BigDecimal((random.nextGaussian() * 0.5 + 1)));
    }

    public static Long generateTemperature(BigDecimal mass) {
        //lets keep it simple for now: http://en.wikipedia.org/wiki/Effective_temperature

        //assume lighter stars are also cooler

        return mass.divide(StellarConstants.SUN_MASS).multiply(new BigDecimal(StellarConstants.SUN_SURFACE_TEMPERATURE)).longValue();
    }
}
