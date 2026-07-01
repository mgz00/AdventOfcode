package sofware.aoc.day07;

import sofware.aoc.core.InputSource;
import sofware.aoc.core.Solver;

public class Day07Solver implements Solver {

    private final TachyonManifold manifold;

    public Day07Solver(InputSource inputSource) {
        this.manifold = new TachyonManifold(inputSource.readAsLines());
    }

    @Override
    public String solvePartOne() {
        BeamSimulation simulation = new BeamSimulation(manifold);
        return String.valueOf(simulation.countSplits());
    }

    @Override
    public String solvePartTwo() {
        BeamSimulation simulation = new BeamSimulation(manifold);
        return String.valueOf(simulation.countTimelines());
    }
}