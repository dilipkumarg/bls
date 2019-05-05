package com.dilipkumarg.projects.bla;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dilipkumarg.projects.bla.analyser.BarrenLandAnalyser;
import com.dilipkumarg.projects.bla.model.Coordinate;
import com.dilipkumarg.projects.bla.model.Farm;
import com.dilipkumarg.projects.bla.model.FarmableLand;

public class BarrenLandAnalyserTest {

    private FarmableLand land;
    private BarrenLandAnalyser analyser = new BarrenLandAnalyser();

    @Before
    public void beforeTest() {
        land = new Farm(400, 600);
    }


    @Test
    public void findFertileLandAreas() {
        final List<Integer> fertileLandAreas = analyser.findFertileLandAreas(land);

        Assert.assertArrayEquals(new Integer[]{240000}, fertileLandAreas.toArray(new Integer[0]));
    }

    @Test
    public void findFertileLandAreas1() {
        land.addBarrenLand(new Coordinate(0, 292), new Coordinate(399, 307));

        final List<Integer> fertileLandAreas = analyser.findFertileLandAreas(land);

        Assert.assertArrayEquals(new Integer[]{116800, 116800}, fertileLandAreas.toArray(new Integer[0]));
    }

    @Test
    public void findFertileLandAreas2() {
        land.addBarrenLand(new Coordinate(48, 192), new Coordinate(351, 207));
        land.addBarrenLand(new Coordinate(48, 392), new Coordinate(351, 407));
        land.addBarrenLand(new Coordinate(120, 52), new Coordinate(135, 547));
        land.addBarrenLand(new Coordinate(260, 52), new Coordinate(275, 547));

        final List<Integer> fertileLandAreas = analyser.findFertileLandAreas(land);

        Assert.assertArrayEquals(new Integer[]{22816, 192608}, fertileLandAreas.toArray(new Integer[0]));
    }
}