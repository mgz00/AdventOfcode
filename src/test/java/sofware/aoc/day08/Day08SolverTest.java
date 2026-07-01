package sofware.aoc.day08;

import sofware.aoc.core.InputSource;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day08SolverTest {

    @Test
    void shouldSolveExample() {
        InputSource inputSource = new FakeInputSource(List.of(
                "162,817,812",
                "57,618,57",
                "906,360,560",
                "592,479,940",
                "352,342,300",
                "466,668,158",
                "542,29,236",
                "431,825,988",
                "739,650,466",
                "52,470,668",
                "216,146,977",
                "819,987,18",
                "117,168,530",
                "805,96,715",
                "346,949,466",
                "970,615,88",
                "941,993,340",
                "862,61,35",
                "984,92,344",
                "425,690,689"
        ));

        Day08Solver solver = new Day08Solver(inputSource);

        assertEquals("40", new CircuitNetwork(exampleBoxes()).connectClosestAndMultiplyLargestCircuits(10) + "");
        assertEquals("25272", solver.solvePartTwo());
    }

    private List<JunctionBox> exampleBoxes() {
        return List.of(
                new JunctionBox(162, 817, 812),
                new JunctionBox(57, 618, 57),
                new JunctionBox(906, 360, 560),
                new JunctionBox(592, 479, 940),
                new JunctionBox(352, 342, 300),
                new JunctionBox(466, 668, 158),
                new JunctionBox(542, 29, 236),
                new JunctionBox(431, 825, 988),
                new JunctionBox(739, 650, 466),
                new JunctionBox(52, 470, 668),
                new JunctionBox(216, 146, 977),
                new JunctionBox(819, 987, 18),
                new JunctionBox(117, 168, 530),
                new JunctionBox(805, 96, 715),
                new JunctionBox(346, 949, 466),
                new JunctionBox(970, 615, 88),
                new JunctionBox(941, 993, 340),
                new JunctionBox(862, 61, 35),
                new JunctionBox(984, 92, 344),
                new JunctionBox(425, 690, 689)
        );
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