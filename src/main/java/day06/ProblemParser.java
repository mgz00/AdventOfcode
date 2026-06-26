package day06;

import java.util.List;

@FunctionalInterface
public interface ProblemParser {
    MathProblem parse(List<String> lines, ColumnRange range);
}