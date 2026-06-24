package day03;

import core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day03SolverTest {

    @Test
    void shouldSolvePartOneExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        ));

        Day03Solver solver = new Day03Solver(inputSource);

        assertEquals("357", solver.solvePartOne());
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