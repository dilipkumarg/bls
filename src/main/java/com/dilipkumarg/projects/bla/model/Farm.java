package com.dilipkumarg.projects.bla.model;

public class Farm implements FarmableLand {

    private final int height;
    private final int width;

    private final boolean[][] barrenLand;

    public Farm(final int width, final int height) {
        this.width = width;
        this.height = height;

        barrenLand = new boolean[width][height];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void addBarrenLand(final Coordinate leftBottom, final Coordinate rightTop) {
        for (int i = leftBottom.getxPoint(); i <= rightTop.getxPoint(); i++) {
            for (int j = leftBottom.getyPoint(); j <= rightTop.getyPoint(); j++) {
                barrenLand[i][j] = true;
            }
        }
    }

    public boolean isBarrenLand(final Coordinate coordinate) {

        int xPoint = coordinate.getxPoint();
        int yPoint = coordinate.getyPoint();

        coordinate.assertRange(this);

        return barrenLand[xPoint][yPoint];
    }
}
