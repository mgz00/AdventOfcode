package day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegionRequestTest {

    @Test
    void shouldParseRegionRequest() {
        RegionRequest region = RegionRequest.from("12x5: 1 0 1 0 2 2");

        assertEquals(12, region.width());
        assertEquals(5, region.height());
        assertEquals(List.of(1, 0, 1, 0, 2, 2), region.shapeCounts());
    }

    @Test
    void shouldRejectInvalidDimensions() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RegionRequest(0, 5, List.of(1))
        );
    }
}