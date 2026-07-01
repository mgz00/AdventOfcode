package sofware.aoc.day12;

import java.util.Comparator;
import java.util.List;

public class PackingEngine {

    private final boolean[][] board;
    private final int width;
    private final int height;

    public PackingEngine(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new boolean[height][width];
    }

    public boolean canFit(List<GiftShape> pieces) {
        int totalArea = pieces.stream()
                .mapToInt(GiftShape::solidArea)
                .sum();

        if (totalArea > width * height) {
            return false;
        }

        List<List<GiftShape>> variantsByPiece = pieces.stream()
                .sorted(Comparator.comparingInt(GiftShape::solidArea).reversed())
                .map(GiftShape::variants)
                .toList();

        return placePiece(0, variantsByPiece);
    }

    private boolean placePiece(int index, List<List<GiftShape>> variantsByPiece) {
        if (index == variantsByPiece.size()) {
            return true;
        }

        for (GiftShape variant : variantsByPiece.get(index)) {
            for (int row = 0; row <= height - variant.height(); row++) {
                for (int column = 0; column <= width - variant.width(); column++) {
                    if (canPlace(variant, row, column)) {
                        place(variant, row, column, true);

                        if (placePiece(index + 1, variantsByPiece)) {
                            return true;
                        }

                        place(variant, row, column, false);
                    }
                }
            }
        }

        return false;
    }

    private boolean canPlace(GiftShape shape, int rowOffset, int columnOffset) {
        for (int row = 0; row < shape.height(); row++) {
            for (int column = 0; column < shape.width(); column++) {
                if (shape.isFilled(row, column)
                        && board[rowOffset + row][columnOffset + column]) {
                    return false;
                }
            }
        }

        return true;
    }

    private void place(
            GiftShape shape,
            int rowOffset,
            int columnOffset,
            boolean occupied
    ) {
        for (int row = 0; row < shape.height(); row++) {
            for (int column = 0; column < shape.width(); column++) {
                if (shape.isFilled(row, column)) {
                    board[rowOffset + row][columnOffset + column] = occupied;
                }
            }
        }
    }
}