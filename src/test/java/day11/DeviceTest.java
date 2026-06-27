package day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {

    @Test
    void shouldParseDevice() {
        Device device = Device.from("you: bbb ccc");

        assertEquals("you", device.name());
        assertEquals(List.of("bbb", "ccc"), device.outputs());
    }

    @Test
    void shouldRejectInvalidLine() {
        assertThrows(IllegalArgumentException.class, () -> Device.from("you bbb ccc"));
    }
}