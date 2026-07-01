package sofware.aoc.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiftShapeTest {

    @Test
    void shouldCreateShapeFromLines() {
        GiftShape shape = GiftShape.fromLines(List.of(
                "###",
                "#..",
                "###"
        ));

        assertEquals(3, shape.width());
        assertEquals(3, shape.height());
        assertEquals(7, shape.solidArea());
        assertTrue(shape.isFilled(0, 0));
        assertFalse(shape.isFilled(1, 1));
    }

    @Test
    void shouldGenerateVariants() {
        GiftShape shape = GiftShape.fromLines(List.of(
                "##.",
                ".#."
        ));

        assertFalse(shape.variants().isEmpty());
    }
}