package day01;

import core.InputSource;
import core.Solver;

import java.util.List;

public class Day01Solver implements Solver {

    private static final int START_POSITION = 50;

    private final List<Rotation> rotations;

    public Day01Solver(InputSource inputSource) {
        this.rotations = inputSource.readAsLines().stream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(Rotation::from)
                .toList();
    }

    @Override
    public String solvePartOne() {
        Dial dial = new Dial(START_POSITION);
        int zeroCount = 0;

        for (Rotation rotation : rotations) {
            dial.rotate(rotation);

            if (dial.pointsToZero()) {
                zeroCount++;
            }
        }

        return String.valueOf(zeroCount);
    }

    @Override
    public String solvePartTwo() {
        Dial dial = new Dial(START_POSITION);
        int zeroCount = 0;

        for (Rotation rotation : rotations) {
            zeroCount += dial.rotateAndCountZeroHits(rotation);
        }

        return String.valueOf(zeroCount);
    }
}