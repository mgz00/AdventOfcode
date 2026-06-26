package day06;

import core.InputSource;
import core.Solver;

import java.util.List;

public class Day06Solver implements Solver {

    private final List<String> lines;
    private final WorksheetParser worksheetParser;

    public Day06Solver(InputSource inputSource) {
        this.lines = inputSource.readAsLines();
        this.worksheetParser = new WorksheetParser();
    }

    @Override
    public String solvePartOne() {
        Worksheet worksheet = worksheetParser.parse(lines, new RowProblemParser());
        return String.valueOf(worksheet.grandTotal());
    }

    @Override
    public String solvePartTwo() {
        Worksheet worksheet = worksheetParser.parse(lines, new ColumnProblemParser());
        return String.valueOf(worksheet.grandTotal());
    }
}