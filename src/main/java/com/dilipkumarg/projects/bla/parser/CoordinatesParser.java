package com.dilipkumarg.projects.bla.parser;

import java.util.ArrayList;
import java.util.List;

import com.dilipkumarg.projects.bla.model.Coordinate;
import com.dilipkumarg.projects.bla.model.Tuple;

public class CoordinatesParser {

    public static List<Tuple<Coordinate, Coordinate>> parse(String coordinatesString) throws ParserException {
        if (coordinatesString.startsWith("{") && coordinatesString.endsWith("}")) {
            final String unBracesString = coordinatesString.substring(1, coordinatesString.length() - 1);

            final String[] coordinateTokens = unBracesString.split(", ");

            List<Tuple<Coordinate, Coordinate>> coordinates = new ArrayList<>(coordinateTokens.length);
            for (final String coordinateToken : coordinateTokens) {
                coordinates.add(parseCoordinateString(coordinateToken));
            }

            return coordinates;

        } else {
            throw new ParserException("String must start and ends with flower braces:" + coordinatesString);
        }
    }

    public static Tuple<Coordinate, Coordinate> parseCoordinateString(String coordinateString) throws ParserException {
        if (coordinateString.startsWith("\"") && coordinateString.endsWith("\"")) {
            final String unQuotedString = coordinateString.substring(1, coordinateString.length() - 1);
            final String[] coordinates = unQuotedString.split(" ");

            Coordinate leftBottom = new Coordinate(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
            Coordinate rightTop = new Coordinate(Integer.parseInt(coordinates[2]), Integer.parseInt(coordinates[3]));

            return new Tuple<>(leftBottom, rightTop);

        } else {
            throw new ParserException("Coordinate string must wrapped in double quotes");
        }
    }
}
