package day12;

import core.InputSource;
import core.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day12Solver implements Solver {

    private final List<GiftShape> shapes;
    private final List<RegionRequest> regions;

    public Day12Solver(InputSource inputSource) {
        FarmParser parser = new FarmParser();
        parser.parse(inputSource.readAsLines());

        this.shapes = parser.shapes();
        this.regions = parser.regions();
    }

    @Override
    public String solvePartOne() {
        long fittingRegions = regions.stream()
                .filter(this::canFitRegion)
                .count();

        return String.valueOf(fittingRegions);
    }

    @Override
    public String solvePartTwo() {
        return "No part two";
    }

    private boolean canFitRegion(RegionRequest region) {
        List<GiftShape> requiredPieces = expandPieces(region);

        PackingEngine engine =
                new PackingEngine(region.width(), region.height());

        return engine.canFit(requiredPieces);
    }

    private List<GiftShape> expandPieces(RegionRequest region) {
        List<GiftShape> pieces = new ArrayList<>();

        IntStream.range(0, region.shapeCounts().size())
                .forEach(index -> {
                    int count = region.shapeCounts().get(index);
                    GiftShape shape = shapes.get(index);

                    IntStream.range(0, count)
                            .forEach(ignored -> pieces.add(shape));
                });

        return pieces;
    }
}