package sofware.aoc.day10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ButtonTest {

    @Test
    void shouldParseAffectedIndexes() {
        Button button = Button.from("0,2,3");

        assertEquals(List.of(0, 2, 3), button.affectedIndexes());
    }
}