package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DialTest {

    @Test
    void shouldRotateRight() {
        Dial dial = new Dial(11);

        dial.rotate(Rotation.from("R8"));

        assertFalse(dial.pointsToZero());
    }

    @Test
    void shouldRotateLeftToZero() {
        Dial dial = new Dial(19);

        dial.rotate(Rotation.from("L19"));

        assertTrue(dial.pointsToZero());
    }

    @Test
    void shouldCountMultipleZeroHits() {
        Dial dial = new Dial(50);

        int hits = dial.rotateAndCountZeroHits(Rotation.from("R1000"));

        assertEquals(10, hits);
    }
}