package sofware.aoc.day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathProblemTest {

    @Test
    void shouldComputeSum() {
        MathProblem problem = new MathProblem(List.of(328L, 64L, 98L), '+');

        assertEquals(490, problem.compute());
    }

    @Test
    void shouldComputeProduct() {
        MathProblem problem = new MathProblem(List.of(123L, 45L, 6L), '*');

        assertEquals(33210, problem.compute());
    }

    @Test
    void shouldRejectUnknownOperator() {
        MathProblem problem = new MathProblem(List.of(1L, 2L), '-');

        assertThrows(IllegalArgumentException.class, problem::compute);
    }
}