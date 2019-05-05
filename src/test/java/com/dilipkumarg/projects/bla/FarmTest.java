package com.dilipkumarg.projects.bla;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dilipkumarg.projects.bla.model.Coordinate;
import com.dilipkumarg.projects.bla.model.Farm;

public class FarmTest {

    private Farm farm;
    private Random random = new Random();

    @Before
    public void before() {
        farm = new Farm(400, 600);
    }

    @Test
    public void test1() {
        final int xPoint = random.nextInt(400);
        final int yPoint = random.nextInt(600);

        Assert.assertFalse(farm.isBarrenLand(new Coordinate(xPoint, yPoint)));
    }

    @Test
    public void test2() {
        farm.addBarrenLand(new Coordinate(0, 292), new Coordinate(399, 307));

        Assert.assertFalse(farm.isBarrenLand(new Coordinate(399, 291)));
        Assert.assertFalse(farm.isBarrenLand(new Coordinate(0, 308)));
        Assert.assertFalse(farm.isBarrenLand(new Coordinate(0, 291)));

        Assert.assertTrue(farm.isBarrenLand(new Coordinate(0, 292)));
        Assert.assertTrue(farm.isBarrenLand(new Coordinate(0, 307)));
        Assert.assertTrue(farm.isBarrenLand(new Coordinate(399, 292)));
        Assert.assertTrue(farm.isBarrenLand(new Coordinate(399, 307)));
        Assert.assertTrue(farm.isBarrenLand(new Coordinate(250, 300)));
    }
}