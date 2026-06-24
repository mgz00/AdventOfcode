package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatteryBankTest {

    @Test
    void shouldCreateBatteryBank() {
        BatteryBank bank = new BatteryBank("12345");

        assertEquals("12345", bank.ratings());
    }

    @Test
    void shouldRejectEmptyBatteryBank() {
        assertThrows(IllegalArgumentException.class, () -> new BatteryBank(""));
        assertThrows(IllegalArgumentException.class, () -> new BatteryBank("   "));
        assertThrows(IllegalArgumentException.class, () -> new BatteryBank(null));
    }
}