package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductIdRangeTest {

    @Test
    void shouldParseRange() {
        ProductIdRange range = ProductIdRange.from("10-20");

        assertEquals(10, range.start());
        assertEquals(20, range.end());
    }

    @Test
    void shouldParseRangeWithSpaces() {
        ProductIdRange range = ProductIdRange.from("  100-200  ");

        assertEquals(100, range.start());
        assertEquals(200, range.end());
    }

    @Test
    void shouldRejectInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> ProductIdRange.from("20"));
        assertThrows(IllegalArgumentException.class, () -> ProductIdRange.from("20-10"));
    }
}
