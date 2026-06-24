package core;

import day01.Day01Solver;
import day02.Day02Solver;
import day03.Day03Solver;

public final class SolverFactory {

    private SolverFactory() {
    }

    public static Solver create(int day, InputSource inputSource) {
        return switch (day) {
            case 1 -> new Day01Solver(inputSource);
            case 2 -> new Day02Solver(inputSource);
            case 3 -> new Day03Solver(inputSource);
            default -> throw new IllegalArgumentException(
                    "Day %02d not implemented".formatted(day)
            );
        };
    }
}