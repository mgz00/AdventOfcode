package day09;

import core.InputSource;
import core.Solver;

import java.util.List;

public class Day09Solver implements Solver {

    private final TheaterFloor theaterFloor;

    public Day09Solver(InputSource inputSource) {
        List<Tile> redTiles = inputSource.readAsStream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(Tile::from)
                .toList();

        this.theaterFloor = new TheaterFloor(redTiles);
    }

    @Override
    public String solvePartOne() {
        return String.valueOf(theaterFloor.largestRectangleArea());
    }

    @Override
    public String solvePartTwo() {
        return String.valueOf(theaterFloor.largestValidRectangleArea());
    }
}