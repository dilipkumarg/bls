package com.dilipkumarg.projects.bla.model;

public class VisitableFarm extends DelegatingFarmableLand {

    private final boolean[][] visitedPoints;

    public VisitableFarm(final FarmableLand land) {
        super(land);

        this.visitedPoints = new boolean[land.getWidth()][land.getHeight()];
    }

    public void markVisited(Coordinate point) {
        point.assertRange(this);

        visitedPoints[point.getxPoint()][point.getyPoint()] = true;
    }

    public boolean isVisited(Coordinate point) {
        point.assertRange(this);

        return visitedPoints[point.getxPoint()][point.getyPoint()];
    }

    public boolean isVisitedOrBarrenLand(Coordinate point) {
        return isVisited(point) || isBarrenLand(point);
    }

    public boolean isNotVisitedOrBarrenLand(Coordinate point) {
        return !isVisitedOrBarrenLand(point);
    }
}
