package de.texxxxas.common.universe;

import java.math.BigDecimal;
import java.math.BigInteger;

public class StellarConstants {
    //Physical Constants

    //Luminosity: L = 4 PI R^2 sigma T^4


    //sigma
    public static final BigDecimal STEFAN_BOLTZMANN_CONSTANT =  new BigDecimal(new BigInteger("5670373"), -14); //[W m^-2 K^-4]


    public static final BigDecimal SUN_MASS = new BigDecimal("1988000000000000000000000000000").setScale(9, BigDecimal.ROUND_DOWN);
    public static final int SUN_SURFACE_TEMPERATURE = 5778;

    public static final BigDecimal EARTH_MASS = new BigDecimal(new BigInteger("5972"), 21);
}
