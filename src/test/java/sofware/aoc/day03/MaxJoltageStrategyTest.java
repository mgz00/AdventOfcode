package sofware.aoc.day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxJoltageStrategyTest {

    @Test
    void shouldCalculateMaximumPairFromExamples() {
        JoltageStrategy strategy = new MaxJoltageStrategy(2);

        assertEquals(98, strategy.calculate(new BatteryBank("987654321111111")));
        assertEquals(89, strategy.calculate(new BatteryBank("811111111111119")));
        assertEquals(78, strategy.calculate(new BatteryBank("234234234234278")));
        assertEquals(92, strategy.calculate(new BatteryBank("818181911112111")));
    }

    @Test
    void shouldCalculateMaximumDozen() {
        JoltageStrategy strategy = new MaxJoltageStrategy(12);

        assertEquals(987654321111L, strategy.calculate(new BatteryBank("987654321111111")));
    }
}