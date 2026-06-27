package day12;

import core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day12SolverTest {

    @Test
    void shouldSolveExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "0:",
                "###",
                "##.",
                "##.",
                "",
                "1:",
                "###",
                "##.",
                ".##",
                "",
                "2:",
                ".##",
                "###",
                "##.",
                "",
                "3:",
                "##.",
                "###",
                "##.",
                "",
                "4:",
                "###",
                "#..",
                "###",
                "",
                "5:",
                "###",
                ".#.",
                "###",
                "",
                "4x4: 0 0 0 0 2 0",
                "12x5: 1 0 1 0 2 2",
                "12x5: 1 0 1 0 3 2"
        ));

        Day12Solver solver = new Day12Solver(inputSource);

        assertEquals("2", solver.solvePartOne());
        assertEquals("No part two", solver.solvePartTwo());
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