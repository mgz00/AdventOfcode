package sofware.aoc.day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class JoltageSolver {

    private record Pattern(JoltageVector vector, int cost) {
    }

    public long minimumPresses(Machine machine) {
        Map<List<Integer>, List<Pattern>> patternsByParity =
                precomputePatterns(machine);

        Map<JoltageVector, Long> memo = new HashMap<>();

        return solve(machine.targetJoltage(), patternsByParity, memo);
    }

    private Map<List<Integer>, List<Pattern>> precomputePatterns(Machine machine) {
        Map<List<Integer>, List<Pattern>> patterns = new HashMap<>();

        int buttonCount = machine.buttons().size();
        int combinations = 1 << buttonCount;

        IntStream.range(0, combinations).forEach(mask -> {
            JoltageVector vector = JoltageVector.zero(machine.targetJoltage().size());

            for (int index = 0; index < buttonCount; index++) {
                if (((mask >> index) & 1) == 1) {
                    vector = vector.add(
                            machine.buttons().get(index)
                                    .joltageVector(machine.targetJoltage().size())
                    );
                }
            }

            int cost = Integer.bitCount(mask);

            patterns.computeIfAbsent(vector.parity(), key -> new java.util.ArrayList<>())
                    .add(new Pattern(vector, cost));
        });

        return patterns;
    }

    private long solve(
            JoltageVector target,
            Map<List<Integer>, List<Pattern>> patternsByParity,
            Map<JoltageVector, Long> memo
    ) {
        if (target.isZero()) {
            return 0;
        }

        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        List<Pattern> candidates =
                patternsByParity.getOrDefault(target.parity(), List.of());

        long best = candidates.stream()
                .filter(pattern -> target.isGreaterOrEqualThan(pattern.vector()))
                .mapToLong(pattern -> {
                    JoltageVector nextTarget =
                            target.subtract(pattern.vector()).divideByTwo();

                    long remaining = solve(nextTarget, patternsByParity, memo);

                    if (remaining == Long.MAX_VALUE) {
                        return Long.MAX_VALUE;
                    }

                    return pattern.cost() + 2 * remaining;
                })
                .min()
                .orElse(Long.MAX_VALUE);

        memo.put(target, best);

        return best;
    }
}