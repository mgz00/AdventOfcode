package sofware.aoc.day02;

import sofware.aoc.core.InputSource;
import sofware.aoc.core.Solver;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Day02Solver implements Solver {

    private final List<ProductIdRange> ranges;

    public Day02Solver(InputSource inputSource) {
        this.ranges = Arrays.stream(inputSource.readAsText().split(","))
                .map(String::trim)
                .filter(text -> !text.isEmpty())
                .map(ProductIdRange::from)
                .toList();
    }

    @Override
    public String solvePartOne() {
        return String.valueOf(sumMatching(ProductId::isInvalid));
    }

    @Override
    public String solvePartTwo() {
        return String.valueOf(sumMatching(ProductId::isInvalidWithRepeatedPattern));
    }

    private long sumMatching(Predicate<ProductId> validator) {
        return ranges.stream()
                .flatMapToLong(ProductIdRange::values)
                .mapToObj(ProductId::new)
                .filter(validator)
                .mapToLong(ProductId::value)
                .sum();
    }
}