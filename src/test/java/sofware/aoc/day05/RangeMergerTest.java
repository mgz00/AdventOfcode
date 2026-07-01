package sofware.aoc.day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RangeMergerTest {

    private final RangeMerger merger = new RangeMerger();

    @Test
    void shouldMergeOverlappingRanges() {
        List<IngredientRange> merged = merger.merge(List.of(
                new IngredientRange(3, 5),
                new IngredientRange(4, 10)
        ));

        assertEquals(List.of(new IngredientRange(3, 10)), merged);
    }

    @Test
    void shouldMergeAdjacentRanges() {
        List<IngredientRange> merged = merger.merge(List.of(
                new IngredientRange(3, 5),
                new IngredientRange(6, 10)
        ));

        assertEquals(List.of(new IngredientRange(3, 10)), merged);
    }

    @Test
    void shouldKeepSeparatedRanges() {
        List<IngredientRange> merged = merger.merge(List.of(
                new IngredientRange(3, 5),
                new IngredientRange(10, 14)
        ));

        assertEquals(List.of(
                new IngredientRange(3, 5),
                new IngredientRange(10, 14)
        ), merged);
    }
}