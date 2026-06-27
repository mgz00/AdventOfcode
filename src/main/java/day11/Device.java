package day11;

import java.util.Arrays;
import java.util.List;

public record Device(String name, List<String> outputs) {

    public Device {
        outputs = List.copyOf(outputs);
    }

    public static Device from(String line) {
        String[] parts = line.split(":");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid device line: " + line);
        }

        String name = parts[0].trim();

        List<String> outputs = Arrays.stream(parts[1].trim().split("\\s+"))
                .map(String::trim)
                .filter(output -> !output.isEmpty())
                .toList();

        return new Device(name, outputs);
    }
}