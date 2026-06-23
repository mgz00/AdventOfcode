package day02;

import core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day02SolverTest {

    @Test
    void shouldSolveExample() {
        InputSource inputSource = new FakeInputSource(
                "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,"
                        + "1698522-1698528,446443-446449,38593856-38593862,565653-565659,"
                        + "824824821-824824827,2121212118-2121212124"
        );

        Day02Solver solver = new Day02Solver(inputSource);

        assertEquals("1227775554", solver.solvePartOne());
        assertEquals("4174379265", solver.solvePartTwo());
    }

    private static class FakeInputSource implements InputSource {

        private final String text;

        private FakeInputSource(String text) {
            this.text = text;
        }

        @Override
        public List<String> readAsLines() {
            return List.of(text);
        }

        @Override
        public Stream<String> readAsStream() {
            return Stream.of(text);
        }

        @Override
        public String readAsText() {
            return text;
        }
    }
}