package sofware.aoc.day07;

import java.util.List;
import java.util.stream.IntStream;

public class TachyonManifold {

    private static final char START = 'S';
    private static final char SPLITTER = '^';

    private final char[][] grid;
    private final int height;
    private final int width;

    public TachyonManifold(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Manifold cannot be empty");
        }

        this.height = lines.size();
        this.width = lines.getFirst().length();
        this.grid = new char[height][width];

        for (int row = 0; row < height; row++) {
            if (lines.get(row).length() != width) {
                throw new IllegalArgumentException("All rows must have the same width");
            }

            grid[row] = lines.get(row).toCharArray();
        }
    }

    public int findStartColumn() {
        return IntStream.range(0, width)
                .filter(column -> grid[0][column] == START)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Start position not found"));
    }

    public boolean isSplitterAt(int row, int column) {
        return isInside(row, column) && grid[row][column] == SPLITTER;
    }

    public boolean isInsideColumn(int column) {
        return column >= 0 && column < width;
    }

    public int height() {
        return height;
    }

    private boolean isInside(int row, int column) {
        return row >= 0 && row < height && isInsideColumn(column);
    }
}