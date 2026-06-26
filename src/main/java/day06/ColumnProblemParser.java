package day06;

import java.util.ArrayList;
import java.util.List;

public class ColumnProblemParser implements ProblemParser {

    @Override
    public MathProblem parse(List<String> lines, ColumnRange range) {
        List<Long> numbers = new ArrayList<>();
        char operator = findOperator(lines, range);

        for (int column = range.end() - 1; column >= range.start(); column--) {
            StringBuilder number = new StringBuilder();

            for (String line : lines) {
                if (column < line.length() && Character.isDigit(line.charAt(column))) {
                    number.append(line.charAt(column));
                }
            }

            if (!number.isEmpty()) {
                numbers.add(Long.parseLong(number.toString()));
            }
        }

        return new MathProblem(numbers, operator);
    }

    private char findOperator(List<String> lines, ColumnRange range) {
        return lines.stream()
                .map(line -> segment(line, range))
                .filter(segment -> segment.contains("+") || segment.contains("*"))
                .map(segment -> segment.contains("+") ? '+' : '*')
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Operator not found"));
    }

    private String segment(String line, ColumnRange range) {
        if (range.start() >= line.length()) {
            return "";
        }

        return line.substring(range.start(), Math.min(range.end(), line.length()));
    }
}