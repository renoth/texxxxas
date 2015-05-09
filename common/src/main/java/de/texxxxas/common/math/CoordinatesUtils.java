package de.texxxxas.common.math;

public class CoordinatesUtils {
    public static long KM_PER_LY = 9_460_528_405_000_000L;

    public static Long distance(Coordinates c1, Coordinates c2) {
        return Math.round(Math.hypot(c1.getX() - c2.getX(), c1.getY() - c2.getY()));
    }

    public static double kmToLy(Long km) {
        return km / KM_PER_LY;
    }

    public static long lyToKm(double ly) {
        return Math.round(ly * KM_PER_LY);
    }
}
