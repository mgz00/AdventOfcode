package sofware.aoc.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void shouldDetectPaperRollAtPosition() {
        Grid grid = new Grid(List.of(
                ".@.",
                "...",
                "..."
        ));

        assertTrue(grid.hasPaperRollAt(new Position(0, 1)));
        assertFalse(grid.hasPaperRollAt(new Position(0, 0)));
    }

    @Test
    void shouldCountAdjacentPaperRolls() {
        Grid grid = new Grid(List.of(
                "@@@",
                "@@@",
                "..."
        ));

        assertEquals(5, grid.countAdjacentPaperRolls(new Position(1, 1)));
    }

    @Test
    void shouldRemovePaperRoll() {
        Grid grid = new Grid(List.of(
                ".@.",
                "...",
                "..."
        ));

        Position position = new Position(0, 1);

        grid.removePaperRollAt(position);

        assertFalse(grid.hasPaperRollAt(position));
    }

    @Test
    void shouldRejectInvalidGrid() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(List.of()));
        assertThrows(IllegalArgumentException.class, () -> new Grid(List.of(
                "@@",
                "@"
        )));
    }
}