package sofware.aoc.day11;

import sofware.aoc.core.InputSource;
import sofware.aoc.core.Solver;

import java.util.List;

public class Day11Solver implements Solver {

    private final ReactorNetwork network;

    public Day11Solver(InputSource inputSource) {
        List<Device> devices = inputSource.readAsStream()
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(Device::from)
                .toList();

        this.network = new ReactorNetwork(devices);
    }

    @Override
    public String solvePartOne() {
        return String.valueOf(network.countPaths("you", "out"));
    }

    @Override
    public String solvePartTwo() {
        return String.valueOf(
                network.countPathsVisitingBoth("svr", "out", "dac", "fft")
        );
    }
}