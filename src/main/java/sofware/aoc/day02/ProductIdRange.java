package sofware.aoc.day02;

import java.util.stream.LongStream;

public record ProductIdRange(long start, long end) {

    public ProductIdRange {
        if (start > end) {
            throw new IllegalArgumentException("Range start cannot be greater than range end");
        }
    }

    public static ProductIdRange from(String text) {
        String[] parts = text.trim().split("-");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid range: " + text);
        }

        return new ProductIdRange(
                Long.parseLong(parts[0]),
                Long.parseLong(parts[1])
        );
    }

    public LongStream values() {
        return LongStream.rangeClosed(start, end);
    }
}