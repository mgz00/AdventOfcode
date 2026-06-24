package day04;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grid {

    private static final char PAPER_ROLL = '@';
    private static final char EMPTY = '.';

    private final char[][] cells;
    private final int rows;
    private final int columns;

    public Grid(List<String> lines) {

        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Grid cannot be empty");
        }

        this.rows = lines.size();
        this.columns = lines.getFirst().length();
        this.cells = new char[rows][columns];

        for (int row = 0; row < rows; row++) {

            if (lines.get(row).length() != columns) {
                throw new IllegalArgumentException(
                        "All rows must have the same length"
                );
            }

            cells[row] = lines.get(row).toCharArray();
        }
    }

    public boolean hasPaperRollAt(Position position) {
        return isInside(position.row(), position.column())
                && cells[position.row()][position.column()] == PAPER_ROLL;
    }

    public void removePaperRollAt(Position position) {
        if (hasPaperRollAt(position)) {
            cells[position.row()][position.column()] = EMPTY;
        }
    }

    public int countAdjacentPaperRolls(Position position) {

        int count = 0;

        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {

            for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {

                if (rowOffset == 0 && columnOffset == 0) {
                    continue;
                }

                int row = position.row() + rowOffset;
                int column = position.column() + columnOffset;

                if (isInside(row, column)
                        && cells[row][column] == PAPER_ROLL) {
                    count++;
                }
            }
        }

        return count;
    }

    public Stream<Position> positions() {

        return IntStream.range(0, rows)
                .boxed()
                .flatMap(row ->
                        IntStream.range(0, columns)
                                .mapToObj(column ->
                                        new Position(row, column)
                                )
                );
    }

    private boolean isInside(int row, int column) {

        return row >= 0
                && row < rows
                && column >= 0
                && column < columns;
    }
}