package sofware.aoc.day09;

import sofware.aoc.core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day09SolverTest {

    @Test
    void shouldSolveExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "7,1",
                "11,1",
                "11,7",
                "9,7",
                "9,5",
                "2,5",
                "2,3",
                "7,3"
        ));

        Day09Solver solver = new Day09Solver(inputSource);

        assertEquals("50", solver.solvePartOne());
        assertEquals("24", solver.solvePartTwo());
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