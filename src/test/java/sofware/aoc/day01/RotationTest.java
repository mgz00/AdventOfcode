package sofware.aoc.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotationTest {

    @Test
    void shouldParseRightRotation() {
        Rotation rotation = Rotation.from("R48");

        assertEquals('R', rotation.direction());
        assertEquals(48, rotation.distance());
        assertEquals(1, rotation.sign());
    }

    @Test
    void shouldParseLeftRotation() {
        Rotation rotation = Rotation.from("L68");

        assertEquals('L', rotation.direction());
        assertEquals(68, rotation.distance());
        assertEquals(-1, rotation.sign());
    }

    @Test
    void shouldRejectInvalidDirection() {
        assertThrows(IllegalArgumentException.class, () -> Rotation.from("X10"));
    }
}