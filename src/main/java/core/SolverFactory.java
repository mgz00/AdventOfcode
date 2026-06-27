package core;

import day01.Day01Solver;
import day02.Day02Solver;
import day03.Day03Solver;
import day04.Day04Solver;
import day05.Day05Solver;
import day06.Day06Solver;
import day07.Day07Solver;
import day08.Day08Solver;
import day09.Day09Solver;
import day10.Day10Solver;
import day11.Day11Solver;
import day12.Day12Solver;



public final class SolverFactory {

    private SolverFactory() {
    }

    public static Solver create(int day, InputSource inputSource) {
        return switch (day) {
            case 1 -> new Day01Solver(inputSource);
            case 2 -> new Day02Solver(inputSource);
            case 3 -> new Day03Solver(inputSource);
            case 4 -> new Day04Solver(inputSource);
            case 5 -> new Day05Solver(inputSource);
            case 6 -> new Day06Solver(inputSource);
            case 7 -> new Day07Solver(inputSource);
            case 8 -> new Day08Solver(inputSource);
            case 9 -> new Day09Solver(inputSource);
            case 10 -> new Day10Solver(inputSource);
            case 11 -> new Day11Solver(inputSource);
            case 12 -> new Day12Solver(inputSource);


            default -> throw new IllegalArgumentException(
                    "Day %02d not implemented".formatted(day)
            );
        };
    }
}