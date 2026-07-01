package sofware.aoc.day10;

import sofware.aoc.core.InputSource;
import sofware.aoc.core.Solver;

import java.util.List;

public class Day10Solver implements Solver {

    private final List<Machine> machines;
    private final IndicatorSolver indicatorSolver;
    private final JoltageSolver joltageSolver;

    public Day10Solver(InputSource inputSource) {
        MachineParser parser = new MachineParser();

        this.machines = inputSource.readAsStream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(parser::parse)
                .toList();

        this.indicatorSolver = new IndicatorSolver();
        this.joltageSolver = new JoltageSolver();
    }

    @Override
    public String solvePartOne() {
        return String.valueOf(
                machines.stream()
                        .mapToLong(indicatorSolver::minimumPresses)
                        .sum()
        );
    }

    @Override
    public String solvePartTwo() {
        return String.valueOf(
                machines.stream()
                        .mapToLong(joltageSolver::minimumPresses)
                        .sum()
        );
    }
}