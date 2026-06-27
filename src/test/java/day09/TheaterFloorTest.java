package day09;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TheaterFloorTest {

    @Test
    void shouldFindLargestRectangleArea() {
        TheaterFloor floor = new TheaterFloor(exampleTiles());

        assertEquals(50, floor.largestRectangleArea());
    }

    @Test
    void shouldFindLargestValidRectangleArea() {
        TheaterFloor floor = new TheaterFloor(exampleTiles());

        assertEquals(24, floor.largestValidRectangleArea());
    }

    private List<Tile> exampleTiles() {
        return List.of(
                new Tile(7, 1),
                new Tile(11, 1),
                new Tile(11, 7),
                new Tile(9, 7),
                new Tile(9, 5),
                new Tile(2, 5),
                new Tile(2, 3),
                new Tile(7, 3)
        );
    }
}