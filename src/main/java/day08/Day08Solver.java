package day08;

import core.InputSource;
import core.Solver;

import java.util.List;

public class Day08Solver implements Solver {

    private static final int CONNECTION_LIMIT = 1000;

    private final CircuitNetwork network;

    public Day08Solver(InputSource inputSource) {
        List<JunctionBox> boxes = inputSource.readAsStream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(JunctionBox::from)
                .toList();

        this.network = new CircuitNetwork(boxes);
    }

    @Override
    public String solvePartOne() {
        return String.valueOf(
                network.connectClosestAndMultiplyLargestCircuits(CONNECTION_LIMIT)
        );
    }

    @Override
    public String solvePartTwo() {
        return String.valueOf(
                network.connectUntilSingleCircuitAndMultiplyLastXCoordinates()
        );
    }
}