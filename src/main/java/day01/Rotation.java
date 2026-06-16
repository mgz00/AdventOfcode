package day01;

public record Rotation(char direction, int distance) {

    public Rotation {
        if (direction != 'L' && direction != 'R') {
            throw new IllegalArgumentException("Invalid direction: " + direction);
        }

        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
    }

    public static Rotation from(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Rotation cannot be null or empty");
        }

        String clean = text.trim();

        return new Rotation(
                clean.charAt(0),
                Integer.parseInt(clean.substring(1))
        );
    }

    public int sign() {
        return direction == 'R' ? 1 : -1;
    }
}