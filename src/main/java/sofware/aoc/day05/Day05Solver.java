package sofware.aoc.day05;

import sofware.aoc.core.InputSource;
import sofware.aoc.core.Solver;

import java.util.List;

public class Day05Solver implements Solver {

    private final InventoryDatabase database;
    private final RangeMerger rangeMerger;

    public Day05Solver(InputSource inputSource) {
        this.database = new InventoryDatabase(inputSource.readAsLines());
        this.rangeMerger = new RangeMerger();
    }

    @Override
    public String solvePartOne() {
        long freshCount = database.availableIds().stream()
                .filter(this::isFresh)
                .count();

        return String.valueOf(freshCount);
    }

    @Override
    public String solvePartTwo() {
        List<IngredientRange> mergedRanges =
                rangeMerger.merge(database.freshRanges());

        long totalFreshIds = mergedRanges.stream()
                .mapToLong(IngredientRange::length)
                .sum();

        return String.valueOf(totalFreshIds);
    }

    private boolean isFresh(long ingredientId) {
        return database.freshRanges().stream()
                .anyMatch(range -> range.contains(ingredientId));
    }
}