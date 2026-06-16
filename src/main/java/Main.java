import core.FileInputSource;
import core.InputSource;
import core.Reporter;
import core.Solver;
import day01.Day01Solver;

public class Main {

    public static void main(String[] args) {
        InputSource inputSource = new FileInputSource("day01.txt");
        Solver solver = new Day01Solver(inputSource);

        Reporter reporter = new Reporter();
        reporter.print(
                "Day 01",
                solver.solvePartOne(),
                solver.solvePartTwo()
        );
    }
}
