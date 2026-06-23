package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductIdTest {

    @Test
    void shouldDetectInvalidIdsForPartOne() {
        assertTrue(new ProductId(11).isInvalid());
        assertTrue(new ProductId(6464).isInvalid());
        assertTrue(new ProductId(123123).isInvalid());
    }

    @Test
    void shouldRejectValidIdsForPartOne() {
        assertFalse(new ProductId(101).isInvalid());
        assertFalse(new ProductId(1234).isInvalid());
        assertFalse(new ProductId(5).isInvalid());
    }

    @Test
    void shouldDetectInvalidIdsForPartTwo() {
        assertTrue(new ProductId(111).isInvalidWithRepeatedPattern());
        assertTrue(new ProductId(121212).isInvalidWithRepeatedPattern());
        assertTrue(new ProductId(123123123).isInvalidWithRepeatedPattern());
    }

    @Test
    void shouldRejectValidIdsForPartTwo() {
        assertFalse(new ProductId(123456).isInvalidWithRepeatedPattern());
        assertFalse(new ProductId(101).isInvalidWithRepeatedPattern());
    }
}