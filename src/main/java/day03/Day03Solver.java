package day03;

import core.InputSource;
import core.Solver;

import java.util.List;

public class Day03Solver implements Solver {

    private static final JoltageStrategy PART_ONE_STRATEGY =
            new MaxJoltageStrategy(2);

    private static final JoltageStrategy PART_TWO_STRATEGY =
            new MaxJoltageStrategy(12);

    private final List<BatteryBank> batteryBanks;

    public Day03Solver(InputSource inputSource) {
        this.batteryBanks = inputSource.readAsStream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(BatteryBank::new)
                .toList();
    }

    @Override
    public String solvePartOne() {
        return solve(PART_ONE_STRATEGY);
    }

    @Override
    public String solvePartTwo() {
        return solve(PART_TWO_STRATEGY);
    }

    private String solve(JoltageStrategy strategy) {
        long total = batteryBanks.stream()
                .mapToLong(strategy::calculate)
                .sum();

        return String.valueOf(total);
    }
}