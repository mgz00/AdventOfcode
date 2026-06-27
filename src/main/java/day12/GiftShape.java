package day12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GiftShape {

    private final boolean[][] cells;
    private final int width;
    private final int height;

    public GiftShape(boolean[][] cells) {
        this.height = cells.length;
        this.width = cells[0].length;
        this.cells = copyOf(cells);
    }

    public static GiftShape fromLines(List<String> lines) {
        int height = lines.size();
        int width = lines.stream()
                .mapToInt(String::length)
                .max()
                .orElseThrow();

        boolean[][] cells = new boolean[height][width];

        for (int row = 0; row < height; row++) {
            String line = lines.get(row);

            for (int column = 0; column < line.length(); column++) {
                cells[row][column] = line.charAt(column) == '#';
            }
        }

        return new GiftShape(cells);
    }

    public List<GiftShape> variants() {
        Set<String> signatures = new HashSet<>();
        List<GiftShape> variants = new ArrayList<>();

        GiftShape current = this;

        for (int flip = 0; flip < 2; flip++) {
            for (int rotation = 0; rotation < 4; rotation++) {
                if (signatures.add(current.signature())) {
                    variants.add(current);
                }

                current = current.rotate();
            }

            current = current.flip();
        }

        return variants;
    }

    public boolean isFilled(int row, int column) {
        return cells[row][column];
    }

    public int solidArea() {
        int area = 0;

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if (cells[row][column]) {
                    area++;
                }
            }
        }

        return area;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    private GiftShape rotate() {
        boolean[][] rotated = new boolean[width][height];

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                rotated[column][height - 1 - row] = cells[row][column];
            }
        }

        return new GiftShape(rotated);
    }

    private GiftShape flip() {
        boolean[][] flipped = new boolean[height][width];

        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                flipped[row][width - 1 - column] = cells[row][column];
            }
        }

        return new GiftShape(flipped);
    }

    private String signature() {
        StringBuilder builder = new StringBuilder();

        for (boolean[] row : cells) {
            for (boolean cell : row) {
                builder.append(cell ? '#' : '.');
            }

            builder.append('\n');
        }

        return builder.toString();
    }

    private boolean[][] copyOf(boolean[][] source) {
        boolean[][] copy = new boolean[source.length][];

        for (int row = 0; row < source.length; row++) {
            copy[row] = source[row].clone();
        }

        return copy;
    }
}