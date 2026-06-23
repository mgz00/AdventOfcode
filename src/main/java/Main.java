import core.FileInputSource;
import core.InputSource;
import core.Reporter;
import core.Solver;
import day02.Day02Solver;

public class Main {

    public static void main(String[] args) {
        InputSource inputSource = new FileInputSource("day02.txt");
        Solver solver = new Day02Solver(inputSource);

        Reporter reporter = new Reporter();
        reporter.print(
                "Day 02",
                solver.solvePartOne(),
                solver.solvePartTwo()
        );
    }
}
