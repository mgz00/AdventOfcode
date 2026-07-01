package sofware.aoc.day06;

import java.util.List;

public record MathProblem(List<Long> numbers, char operator) {
    public MathProblem {
        numbers = List.copyOf(numbers);
    }

    public long compute() {
        return switch (operator) {
            case '+' -> numbers.stream()
                    .mapToLong(Long::longValue)
                    .sum();

            case '*' -> numbers.stream()
                    .mapToLong(Long::longValue)
                    .reduce(1, (a, b) -> a * b);

            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}