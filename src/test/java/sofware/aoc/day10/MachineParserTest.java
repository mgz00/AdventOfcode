package sofware.aoc.day10;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MachineParserTest {

    @Test
    void shouldParseMachine() {
        Machine machine = new MachineParser()
                .parse("[.##.] (3) (1,3) (2) {3,5,4,7}");

        assertEquals(6L, machine.targetMask());
        assertEquals(3, machine.buttons().size());

        assertEquals(
                new JoltageVector(List.of(
                        BigInteger.valueOf(3),
                        BigInteger.valueOf(5),
                        BigInteger.valueOf(4),
                        BigInteger.valueOf(7)
                )),
                machine.targetJoltage()
        );
    }
}