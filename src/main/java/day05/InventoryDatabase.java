package day05;

import java.util.ArrayList;
import java.util.List;

public class InventoryDatabase {

    private final List<IngredientRange> freshRanges;
    private final List<Long> availableIds;

    public InventoryDatabase(List<String> lines) {
        this.freshRanges = new ArrayList<>();
        this.availableIds = new ArrayList<>();

        boolean readingAvailableIds = false;

        for (String line : lines) {
            String clean = line.trim();

            if (clean.isEmpty()) {
                readingAvailableIds = true;
                continue;
            }

            if (readingAvailableIds) {
                availableIds.add(Long.parseLong(clean));
            } else {
                freshRanges.add(IngredientRange.from(clean));
            }
        }
    }

    public List<IngredientRange> freshRanges() {
        return List.copyOf(freshRanges);
    }

    public List<Long> availableIds() {
        return List.copyOf(availableIds);
    }
}