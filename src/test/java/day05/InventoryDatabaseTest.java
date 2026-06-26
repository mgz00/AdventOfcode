package day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryDatabaseTest {

    @Test
    void shouldParseRangesAndAvailableIds() {
        InventoryDatabase database = new InventoryDatabase(List.of(
                "3-5",
                "10-14",
                "",
                "1",
                "5",
                "8"
        ));

        assertEquals(2, database.freshRanges().size());
        assertEquals(3, database.availableIds().size());

        assertEquals(new IngredientRange(3, 5), database.freshRanges().get(0));
        assertEquals(List.of(1L, 5L, 8L), database.availableIds());
    }
}