package sofware.aoc.core;

public class Reporter {

    public void print(String dayName, String partOne, String partTwo) {
        System.out.println("=== " + dayName + " ===");
        System.out.println("Part 1: " + partOne);
        System.out.println("Part 2: " + partTwo);
        System.out.println();
    }
}