package de.texxxxas.common.math;

public class Coordinates {
    private Long x, y;

    public Coordinates() {

    }

    /**
     * Constructor for Lightyear coordinates
     */
    public Coordinates(double x, double y) {
        this.x = CoordinatesUtils.lyToKm(x);
        this.y = CoordinatesUtils.lyToKm(y);
    }

    /**
     * Constructor for km coordinates
     */
    public Coordinates(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }
}
