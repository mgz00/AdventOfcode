package sofware.aoc.day12;

import java.util.Arrays;
import java.util.List;

public record RegionRequest(int width, int height, List<Integer> shapeCounts) {

    public RegionRequest {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Region dimensions must be positive");
        }

        shapeCounts = List.copyOf(shapeCounts);
    }

    public static RegionRequest from(String line) {
        String[] parts = line.split(":");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid region: " + line);
        }

        String[] dimensions = parts[0].trim().split("x");

        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);

        List<Integer> counts = Arrays.stream(parts[1].trim().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        return new RegionRequest(width, height, counts);
    }
}