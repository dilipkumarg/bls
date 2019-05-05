package com.dilipkumarg.projects.bla.parser;

import java.util.List;

import org.junit.Test;

import com.dilipkumarg.projects.bla.model.Coordinate;
import com.dilipkumarg.projects.bla.model.Tuple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoordinatesParserTest {

    @Test
    public void parse() throws ParserException {
        final List<Tuple<Coordinate, Coordinate>> coodinates = CoordinatesParser.parse("{\"0 292 399 307\"}");

        assertEquals(1, coodinates.size());
        assertEquals(new Coordinate(0, 292), coodinates.get(0).getKey());
        assertEquals(new Coordinate(399, 307), coodinates.get(0).getValue());
    }

    @Test
    public void parse1() throws ParserException {
        final List<Tuple<Coordinate, Coordinate>> coordinates = CoordinatesParser
                .parse("{\"48 192 351 207\", \"48 392 351 407\", \"120 52 135 547\", \"260 52 275 547\"}");

        assertEquals(4, coordinates.size());
        assertEquals(new Tuple<>(new Coordinate(48, 192), new Coordinate(351, 207)), coordinates.get(0));
        assertEquals(new Tuple<>(new Coordinate(48, 392), new Coordinate(351, 407)), coordinates.get(1));
        assertEquals(new Tuple<>(new Coordinate(120, 52), new Coordinate(135, 547)), coordinates.get(2));
        assertEquals(new Tuple<>(new Coordinate(260, 52), new Coordinate(275, 547)), coordinates.get(3));
    }

    @Test(expected = ParserException.class)
    public void parse2() throws ParserException {
        CoordinatesParser
                .parse("\"48 192 351 207”, \"48 392 351 407”, \"120 52 135 547”, \"260 52 275 547”}");

        fail("should fail parsing here");
    }

    @Test
    public void parseCoordinateString() throws ParserException {
        final Tuple<Coordinate, Coordinate> coordinateTuple = CoordinatesParser
                .parseCoordinateString("\"0 292 399 307\"");

        assertEquals(new Coordinate(0, 292), coordinateTuple.getKey());
        assertEquals(new Coordinate(399, 307), coordinateTuple.getValue());
    }

    @Test
    public void parseCoordinateString1() throws ParserException {
        final Tuple<Coordinate, Coordinate> coordinateTuple = CoordinatesParser
                .parseCoordinateString("\"48 192 351 207\"");

        assertEquals(new Coordinate(48, 192), coordinateTuple.getKey());
        assertEquals(new Coordinate(351, 207), coordinateTuple.getValue());
    }

    @Test(expected = ParserException.class)
    public void parseCoordinateString2() throws ParserException {
        CoordinatesParser.parseCoordinateString("0 292 399 307");

        fail("Should fail parsing");
    }
}