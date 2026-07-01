package sofware.aoc.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void shouldParseTile() {
        Tile tile = Tile.from("7,1");

        assertEquals(7, tile.x());
        assertEquals(1, tile.y());
    }

    @Test
    void shouldCalculateRectangleArea() {
        Tile first = new Tile(2, 5);
        Tile second = new Tile(9, 7);

        assertEquals(24, first.rectangleAreaWith(second));
    }
}