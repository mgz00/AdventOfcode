package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPairJoltageStrategyTest {

    private final JoltageStrategy strategy = new MaxPairJoltageStrategy();

    @Test
    void shouldCalculateMaximumPairFromExamples() {
        assertEquals(98, strategy.calculate(new BatteryBank("987654321111111")));
        assertEquals(89, strategy.calculate(new BatteryBank("811111111111119")));
        assertEquals(78, strategy.calculate(new BatteryBank("234234234234278")));
        assertEquals(92, strategy.calculate(new BatteryBank("818181911112111")));
    }
}