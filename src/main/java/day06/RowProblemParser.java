package day06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class RowProblemParser implements ProblemParser {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    @Override
    public MathProblem parse(List<String> lines, ColumnRange range) {
        List<Long> numbers = new ArrayList<>();
        char operator = findOperator(lines, range);

        for (String line : lines) {
            String segment = segment(line, range);

            if (segment.contains("+") || segment.contains("*")) {
                continue;
            }

            NUMBER_PATTERN.matcher(segment)
                    .results()
                    .map(match -> Long.parseLong(match.group()))
                    .forEach(numbers::add);
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