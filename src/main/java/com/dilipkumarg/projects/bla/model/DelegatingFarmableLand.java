package com.dilipkumarg.projects.bla.model;

public class DelegatingFarmableLand implements FarmableLand {
    private final FarmableLand delgate;

    public DelegatingFarmableLand(final FarmableLand delgate) {
        this.delgate = delgate;
    }

    @Override
    public int getHeight() {
        return delgate.getHeight();
    }

    @Override
    public int getWidth() {
        return delgate.getWidth();
    }

    @Override
    public void addBarrenLand(final Coordinate leftBottom, final Coordinate rightTop) {
        delgate.addBarrenLand(leftBottom, rightTop);
    }

    @Override
    public boolean isBarrenLand(final Coordinate coordinate) {
        return delgate.isBarrenLand(coordinate);
    }

    @Override
    public boolean isFertileLand(final Coordinate coordinate) {
        return delgate.isFertileLand(coordinate);
    }
}
