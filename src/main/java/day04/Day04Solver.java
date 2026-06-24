package day04;

import core.InputSource;
import core.Solver;

import java.util.List;

public class Day04Solver implements Solver {

    private static final int MAX_ALLOWED_ADJACENT_ROLLS = 3;

    private final List<String> lines;

    public Day04Solver(InputSource inputSource) {
        this.lines = inputSource.readAsLines();
    }

    @Override
    public String solvePartOne() {

        Grid grid = new Grid(lines);

        return String.valueOf(
                findAccessibleRolls(grid).size()
        );
    }

    @Override
    public String solvePartTwo() {

        Grid grid = new Grid(lines);

        long removedRolls = 0;

        while (true) {

            List<Position> accessibleRolls =
                    findAccessibleRolls(grid);

            if (accessibleRolls.isEmpty()) {
                break;
            }

            accessibleRolls.forEach(grid::removePaperRollAt);

            removedRolls += accessibleRolls.size();
        }

        return String.valueOf(removedRolls);
    }

    private List<Position> findAccessibleRolls(Grid grid) {

        return grid.positions()
                .filter(grid::hasPaperRollAt)
                .filter(position ->
                        grid.countAdjacentPaperRolls(position)
                                <= MAX_ALLOWED_ADJACENT_ROLLS
                )
                .toList();
    }
}