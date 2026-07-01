package sofware.aoc.day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeMerger {

    public List<IngredientRange> merge(List<IngredientRange> ranges) {
        if (ranges.isEmpty()) {
            return List.of();
        }

        List<IngredientRange> sortedRanges = new ArrayList<>(ranges);
        Collections.sort(sortedRanges);

        List<IngredientRange> mergedRanges = new ArrayList<>();
        IngredientRange current = sortedRanges.getFirst();

        for (int index = 1; index < sortedRanges.size(); index++) {
            IngredientRange next = sortedRanges.get(index);

            if (current.canMergeWith(next)) {
                current = current.mergeWith(next);
            } else {
                mergedRanges.add(current);
                current = next;
            }
        }

        mergedRanges.add(current);

        return mergedRanges;
    }
}