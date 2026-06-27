package day10;

import core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day10SolverTest {

    @Test
    void shouldSolveExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}",
                "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}",
                "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
        ));

        Day10Solver solver = new Day10Solver(inputSource);

        assertEquals("7", solver.solvePartOne());
        assertEquals("33", solver.solvePartTwo());
    }

    private static class FakeInputSource implements InputSource {

        private final List<String> lines;

        private FakeInputSource(List<String> lines) {
            this.lines = lines;
        }

        @Override
        public List<String> readAsLines() {
            return lines;
        }

        @Override
        public Stream<String> readAsStream() {
            return lines.stream();
        }

        @Override
        public String readAsText() {
            return String.join(System.lineSeparator(), lines);
        }
    }
}