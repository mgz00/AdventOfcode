package sofware.aoc.day03;

public record BatteryBank(String ratings) {

    public BatteryBank {
        if (ratings == null || ratings.isBlank()) {
            throw new IllegalArgumentException("Battery bank cannot be empty");
        }
    }
}