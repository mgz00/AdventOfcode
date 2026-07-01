package sofware.aoc.day05;

import sofware.aoc.core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day05SolverTest {

    @Test
    void shouldSolvePartOneExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "3-5",
                "10-14",
                "16-20",
                "12-18",
                "",
                "1",
                "5",
                "8",
                "11",
                "17",
                "32"
        ));

        Day05Solver solver = new Day05Solver(inputSource);

        assertEquals("3", solver.solvePartOne());
    }

    @Test
    void shouldSolvePartTwoExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "3-5",
                "10-14",
                "16-20",
                "12-18",
                "",
                "1",
                "5",
                "8",
                "11",
                "17",
                "32"
        ));

        Day05Solver solver = new Day05Solver(inputSource);

        assertEquals("14", solver.solvePartTwo());
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