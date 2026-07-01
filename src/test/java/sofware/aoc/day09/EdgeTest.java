package sofware.aoc.day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void shouldDetectVerticalEdge() {
        Edge edge = new Edge(new Tile(2, 3), new Tile(2, 5));

        assertTrue(edge.isVertical());
        assertFalse(edge.isHorizontal());
    }

    @Test
    void shouldDetectHorizontalEdge() {
        Edge edge = new Edge(new Tile(2, 3), new Tile(7, 3));

        assertTrue(edge.isHorizontal());
        assertFalse(edge.isVertical());
    }

    @Test
    void shouldContainTileOnEdge() {
        Edge edge = new Edge(new Tile(2, 3), new Tile(2, 5));

        assertTrue(edge.contains(new Tile(2, 4)));
        assertFalse(edge.contains(new Tile(3, 4)));
    }
}