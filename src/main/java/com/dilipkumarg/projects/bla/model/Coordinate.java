package com.dilipkumarg.projects.bla.model;

import java.util.Objects;

public class Coordinate {

    private final int xPoint;
    private final int yPoint;

    public Coordinate(final int xPoint, final int yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    public int getxPoint() {
        return xPoint;
    }

    public int getyPoint() {
        return yPoint;
    }

    public Coordinate up() {
        return new Coordinate(xPoint, yPoint + 1);
    }

    public Coordinate down() {
        return new Coordinate(xPoint, yPoint - 1);
    }

    public Coordinate left() {
        return new Coordinate(xPoint - 1, yPoint);
    }

    public Coordinate right() {
        return new Coordinate(xPoint + 1, yPoint);
    }


    public void assertRange(FarmableLand land) {
        if (xPoint < 0 || xPoint >= land.getWidth()) {
            throw new IllegalArgumentException(
                    "Point:" + xPoint + " not foundThis farm has width of:" + land.getWidth());
        }

        if (yPoint < 0 || yPoint >= land.getHeight()) {
            throw new IllegalArgumentException(
                    "Point:" + yPoint + " not foundThis farm has height of:" + land.getHeight());
        }
    }

    public boolean validateRange(FarmableLand land) {
        try {
            assertRange(land);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getxPoint(), getyPoint());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        final Coordinate that = (Coordinate) o;
        return getxPoint() == that.getxPoint() &&
                getyPoint() == that.getyPoint();
    }
}
