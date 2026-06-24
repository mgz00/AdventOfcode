package day03;

import core.InputSource;
import core.Solver;

import java.util.List;

public class Day03Solver implements Solver {

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
        return String.valueOf(sumUsing(new MaxPairJoltageStrategy()));
    }

    @Override
    public String solvePartTwo() {
        return String.valueOf(sumUsing(new MaxDozenJoltageStrategy()));
    }

    private long sumUsing(JoltageStrategy strategy) {
        return batteryBanks.stream()
                .mapToLong(strategy::calculate)
                .sum();
    }
}