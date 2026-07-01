package sofware.aoc.day10;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public record Button(List<Integer> affectedIndexes) {

    public Button {
        affectedIndexes = List.copyOf(affectedIndexes);
    }

    public static Button from(String text) {
        List<Integer> indexes = Arrays.stream(text.split(","))
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .map(Integer::parseInt)
                .toList();

        return new Button(indexes);
    }

    public long lightMask() {
        return affectedIndexes.stream()
                .mapToLong(index -> 1L << index)
                .reduce(0L, (a, b) -> a | b);
    }

    public JoltageVector joltageVector(int size) {
        List<BigInteger> values = IntStream.range(0, size)
                .mapToObj(index ->
                        affectedIndexes.contains(index)
                                ? BigInteger.ONE
                                : BigInteger.ZERO
                )
                .toList();

        return new JoltageVector(values);
    }
}