package com.dilipkumarg.projects.bla.factory;

import java.util.List;

import com.dilipkumarg.projects.bla.model.Coordinate;
import com.dilipkumarg.projects.bla.model.Farm;
import com.dilipkumarg.projects.bla.model.FarmableLand;
import com.dilipkumarg.projects.bla.model.Tuple;
import com.dilipkumarg.projects.bla.parser.CoordinatesParser;
import com.dilipkumarg.projects.bla.parser.ParserException;

public class FarmFactory {

    public FarmableLand create(int width, int height, String coordinatesString) throws ParserException {
        final List<Tuple<Coordinate, Coordinate>> coordinates = CoordinatesParser.parse(coordinatesString);

        FarmableLand farmableLand = new Farm(width, height);
        coordinates.forEach(tuple -> farmableLand.addBarrenLand(tuple.getKey(), tuple.getValue()));

        return farmableLand;
    }
}
