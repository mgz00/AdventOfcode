package sofware.aoc.day04;

import sofware.aoc.core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day04SolverTest {

    @Test
    void shouldSolveExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "..@@.@@@@.",
                "@@@.@.@.@@",
                "@@@@@.@.@@",
                "@.@@@@..@.",
                "@@.@@@@.@@",
                ".@@@@@@@.@",
                ".@.@.@.@@@",
                "@.@@@.@@@@",
                ".@@@@@@@@.",
                "@.@.@@@.@."
        ));

        Day04Solver solver = new Day04Solver(inputSource);

        assertEquals("13", solver.solvePartOne());
        assertEquals("43", solver.solvePartTwo());
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