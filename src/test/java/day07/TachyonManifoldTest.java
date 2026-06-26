package day07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TachyonManifoldTest {

    @Test
    void shouldFindStartColumn() {
        TachyonManifold manifold = new TachyonManifold(List.of(
                "...S...",
                "......."
        ));

        assertEquals(3, manifold.findStartColumn());
    }

    @Test
    void shouldDetectSplitter() {
        TachyonManifold manifold = new TachyonManifold(List.of(
                "...S...",
                "..^...."
        ));

        assertTrue(manifold.isSplitterAt(1, 2));
        assertFalse(manifold.isSplitterAt(1, 3));
    }

    @Test
    void shouldRejectInvalidManifold() {
        assertThrows(IllegalArgumentException.class, () -> new TachyonManifold(List.of()));
        assertThrows(IllegalArgumentException.class, () -> new TachyonManifold(List.of(
                "...S",
                ".."
        )));
    }
}