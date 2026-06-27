package day09;

public record Tile(int x, int y) {

    public static Tile from(String line) {
        String[] parts = line.trim().split(",");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid tile: " + line);
        }

        return new Tile(
                Integer.parseInt(parts[0]),
                Integer.parseInt(parts[1])
        );
    }

    public long rectangleAreaWith(Tile other) {
        long width = Math.abs(x - other.x) + 1L;
        long height = Math.abs(y - other.y) + 1L;

        return width * height;
    }
}