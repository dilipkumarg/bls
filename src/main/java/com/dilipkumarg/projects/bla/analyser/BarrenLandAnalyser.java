package com.dilipkumarg.projects.bla.analyser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dilipkumarg.projects.bla.model.Coordinate;
import com.dilipkumarg.projects.bla.model.FarmableLand;
import com.dilipkumarg.projects.bla.model.VisitableFarm;

public class BarrenLandAnalyser {

    public List<Integer> findFertileLandAreas(FarmableLand farmableLand) {
        VisitableFarm farm = new VisitableFarm(farmableLand);
        List<Integer> fertileLandAreas = new ArrayList<>();

        for (int i = 0; i < farm.getWidth(); i++) {
            for (int j = 0; j < farm.getHeight(); j++) {
                final Coordinate point = new Coordinate(i, j);
                if (farm.isNotVisitedOrBarrenLand(point)) {
                    fertileLandAreas.add(countFertileLandArea(farm, point));
                }
            }
        }

        fertileLandAreas.sort(Integer::compareTo);

        return fertileLandAreas;
    }

    private int countFertileLandArea(VisitableFarm farm, Coordinate coordinate) {
        int area = 0;
        Stack<Coordinate> traversalStack = new Stack<>();
        traversalStack.push(coordinate);

        while (!traversalStack.empty()) {
            final Coordinate traversingCoordinate = traversalStack.pop();

            if (traversingCoordinate.validateRange(farm)
                    && farm.isNotVisitedOrBarrenLand(traversingCoordinate)) {
                area++;
                farm.markVisited(traversingCoordinate);

                traversalStack.add(traversingCoordinate.up());
                traversalStack.add(traversingCoordinate.down());
                traversalStack.add(traversingCoordinate.left());
                traversalStack.add(traversingCoordinate.right());
            }
        }
        return area;
    }

}
