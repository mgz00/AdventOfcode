package sofware.aoc.day10;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

public record JoltageVector(List<BigInteger> values) {

    public JoltageVector {
        values = List.copyOf(values);
    }

    public static JoltageVector zero(int size) {
        return new JoltageVector(
                IntStream.range(0, size)
                        .mapToObj(i -> BigInteger.ZERO)
                        .toList()
        );
    }

    public JoltageVector add(JoltageVector other) {
        return new JoltageVector(
                IntStream.range(0, values.size())
                        .mapToObj(i -> values.get(i).add(other.values.get(i)))
                        .toList()
        );
    }

    public JoltageVector subtract(JoltageVector other) {
        return new JoltageVector(
                IntStream.range(0, values.size())
                        .mapToObj(i -> values.get(i).subtract(other.values.get(i)))
                        .toList()
        );
    }

    public JoltageVector divideByTwo() {
        return new JoltageVector(
                values.stream()
                        .map(value -> value.divide(BigInteger.TWO))
                        .toList()
        );
    }

    public List<Integer> parity() {
        return values.stream()
                .map(value -> value.mod(BigInteger.TWO).intValue())
                .toList();
    }

    public boolean isZero() {
        return values.stream()
                .allMatch(BigInteger.ZERO::equals);
    }

    public boolean isGreaterOrEqualThan(JoltageVector other) {
        return IntStream.range(0, values.size())
                .allMatch(i -> values.get(i).compareTo(other.values.get(i)) >= 0);
    }

    public int size() {
        return values.size();
    }
}