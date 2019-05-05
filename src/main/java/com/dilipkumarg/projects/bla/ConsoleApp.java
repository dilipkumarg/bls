package com.dilipkumarg.projects.bla;


import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.dilipkumarg.projects.bla.analyser.BarrenLandAnalyser;
import com.dilipkumarg.projects.bla.factory.FarmFactory;
import com.dilipkumarg.projects.bla.model.FarmableLand;
import com.dilipkumarg.projects.bla.parser.ParserException;

public class ConsoleApp {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;

    public static void main(String[] args) throws ParserException {
        FarmFactory farmFactory = new FarmFactory();
        BarrenLandAnalyser analyser = new BarrenLandAnalyser();

        try (Scanner scanner = new Scanner(System.in)) {
            final String coordinatesString = scanner.nextLine();
            final FarmableLand farmableLand = farmFactory.create(WIDTH, HEIGHT, coordinatesString);

            final List<Integer> fertileLandAreas = analyser.findFertileLandAreas(farmableLand);

            System.out.println(fertileLandAreas.stream() // NOSONAR
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));

        }
    }
}
