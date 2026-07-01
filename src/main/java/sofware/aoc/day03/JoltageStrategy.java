package sofware.aoc.day03;

@FunctionalInterface
public interface JoltageStrategy {
    long calculate(BatteryBank batteryBank);
}