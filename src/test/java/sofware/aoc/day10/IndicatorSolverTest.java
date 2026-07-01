package sofware.aoc.day10;

import org.junit.jupiter.api.Test;

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