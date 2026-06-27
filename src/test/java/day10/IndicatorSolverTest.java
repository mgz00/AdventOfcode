package day10;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndicatorSolverTest {

    @Test
    void shouldSolveFirstExampleMachine() {
        Machine machine = new MachineParser()
                .parse("[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}");

        IndicatorSolver solver = new IndicatorSolver();

        assertEquals(2, solver.minimumPresses(machine));
    }
}