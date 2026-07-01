import sofware.aoc.core.FileInputSource;
import sofware.aoc.core.InputSource;
import sofware.aoc.core.Reporter;
import sofware.aoc.core.Solver;
import sofware.aoc.core.SolverFactory;

public class Main {

    public static void main(String[] args) {

        int day = 12;

        InputSource inputSource =
                new FileInputSource("day%02d.txt".formatted(day));

        Solver solver = SolverFactory.create(day, inputSource);

        Reporter reporter = new Reporter();

        reporter.print(
                "Day %02d".formatted(day),
                solver.solvePartOne(),
                solver.solvePartTwo()
        );
    }
}