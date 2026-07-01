package sofware.aoc.day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientRangeTest {

    @Test
    void shouldParseRange() {
        IngredientRange range = IngredientRange.from("3-5");

        assertEquals(3, range.start());
        assertEquals(5, range.end());
    }

    @Test
    void shouldCheckIfContainsIngredientId() {
        IngredientRange range = new IngredientRange(10, 14);

        assertTrue(range.contains(10));
        assertTrue(range.contains(12));
        assertTrue(range.contains(14));
        assertFalse(range.contains(9));
        assertFalse(range.contains(15));
    }

    @Test
    void shouldRejectInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> new IngredientRange(8, 3));
        assertThrows(IllegalArgumentException.class, () -> IngredientRange.from("3"));
    }

    @Test
    void shouldCalculateLength() {
        IngredientRange range = new IngredientRange(3, 5);

        assertEquals(3, range.length());
    }
}