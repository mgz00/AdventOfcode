package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxDozenJoltageStrategyTest {

    private final JoltageStrategy strategy = new MaxDozenJoltageStrategy();

    @Test
    void shouldCalculateMaximumDozen() {
        assertEquals(987654321111L, strategy.calculate(new BatteryBank("987654321111111")));
    }
}