import core.FileInputSource;
import core.InputSource;
import core.Reporter;
import core.Solver;
import core.SolverFactory;

public class Main {

    public static void main(String[] args) {

        int day = 7;

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