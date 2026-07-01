package sofware.aoc.day10;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JoltageVectorTest {

    @Test
    void shouldAddVectors() {
        JoltageVector first = new JoltageVector(List.of(
                BigInteger.ONE,
                BigInteger.TWO
        ));

        JoltageVector second = new JoltageVector(List.of(
                BigInteger.TWO,
                BigInteger.ONE
        ));

        assertEquals(
                new JoltageVector(List.of(
                        BigInteger.valueOf(3),
                        BigInteger.valueOf(3)
                )),
                first.add(second)
        );
    }

    @Test
    void shouldCalculateParity() {
        JoltageVector vector = new JoltageVector(List.of(
                BigInteger.valueOf(3),
                BigInteger.valueOf(4),
                BigInteger.valueOf(5)
        ));

        assertEquals(List.of(1, 0, 1), vector.parity());
    }
}