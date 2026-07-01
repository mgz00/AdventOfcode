package sofware.aoc.day06;

import java.util.ArrayList;
import java.util.List;

public class WorksheetParser {

    public Worksheet parse(List<String> lines, ProblemParser problemParser) {
        List<MathProblem> problems = new ArrayList<>();

        for (ColumnRange range : findProblemRanges(lines)) {
            problems.add(problemParser.parse(lines, range));
        }

        return new Worksheet(problems);
    }

    private List<ColumnRange> findProblemRanges(List<String> lines) {
        int width = lines.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        List<ColumnRange> ranges = new ArrayList<>();
        int start = -1;

        for (int column = 0; column < width; column++) {
            boolean emptyColumn = isEmptyColumn(lines, column);

            if (!emptyColumn && start == -1) {
                start = column;
            }

            if (emptyColumn && start != -1) {
                ranges.add(new ColumnRange(start, column));
                start = -1;
            }
        }

        if (start != -1) {
            ranges.add(new ColumnRange(start, width));
        }

        return ranges;
    }

    private boolean isEmptyColumn(List<String> lines, int column) {
        return lines.stream()
                .allMatch(line ->
                        column >= line.length()
                                || Character.isWhitespace(line.charAt(column))
                );
    }
}