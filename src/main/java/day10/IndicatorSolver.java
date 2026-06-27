package day10;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IndicatorSolver {

    public long minimumPresses(Machine machine) {
        int buttonCount = machine.buttons().size();
        long combinations = 1L << buttonCount;

        return LongStream.range(0, combinations)
                .filter(mask -> producesTarget(machine, mask))
                .map(Long::bitCount)
                .min()
                .orElseThrow();
    }

    private boolean producesTarget(Machine machine, long mask) {
        long result = IntStream.range(0, machine.buttons().size())
                .filter(index -> ((mask >> index) & 1L) == 1L)
                .mapToLong(index -> machine.buttons().get(index).lightMask())
                .reduce(0L, (a, b) -> a ^ b);

        return result == machine.targetMask();
    }
}