package day06;

import java.util.List;

public record Worksheet(List<MathProblem> problems) {

    public Worksheet {
        problems = List.copyOf(problems);
    }

    public long grandTotal() {
        return problems.stream()
                .mapToLong(MathProblem::compute)
                .sum();
    }
}