package com.dilipkumarg.projects.bla.model;

public interface FarmableLand {

    int getHeight();

    int getWidth();

    void addBarrenLand(final Coordinate leftBottom, final Coordinate rightTop);

    boolean isBarrenLand(final Coordinate coordinate);

    default boolean isFertileLand(final Coordinate coordinate) {
        return !isBarrenLand(coordinate);
    }
}
