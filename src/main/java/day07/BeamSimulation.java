package day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BeamSimulation {

    private final TachyonManifold manifold;

    public BeamSimulation(TachyonManifold manifold) {
        this.manifold = manifold;
    }

    public long countSplits() {
        Set<Integer> activeColumns = Set.of(manifold.findStartColumn());
        long splitCount = 0;

        for (int row = 0; row < manifold.height(); row++) {
            splitCount += countSplittersHit(activeColumns, row);
            activeColumns = advanceColumns(activeColumns, row);

            if (activeColumns.isEmpty()) {
                break;
            }
        }

        return splitCount;
    }

    public long countTimelines() {
        Map<Integer, Long> timelinesByColumn = Map.of(
                manifold.findStartColumn(), 1L
        );

        for (int row = 0; row < manifold.height(); row++) {
            timelinesByColumn = advanceTimelines(timelinesByColumn, row);

            if (timelinesByColumn.isEmpty()) {
                break;
            }
        }

        return timelinesByColumn.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }

    private long countSplittersHit(Set<Integer> activeColumns, int row) {
        return activeColumns.stream()
                .filter(column -> manifold.isSplitterAt(row, column))
                .count();
    }

    private Set<Integer> advanceColumns(Set<Integer> activeColumns, int row) {
        return activeColumns.stream()
                .flatMap(column -> nextColumns(column, row).stream())
                .filter(manifold::isInsideColumn)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private Map<Integer, Long> advanceTimelines(Map<Integer, Long> timelinesByColumn, int row) {
        Map<Integer, Long> nextState = new HashMap<>();

        timelinesByColumn.forEach((column, timelines) ->
                nextColumns(column, row).stream()
                        .filter(manifold::isInsideColumn)
                        .forEach(nextColumn ->
                                nextState.merge(nextColumn, timelines, Long::sum)
                        )
        );

        return nextState;
    }

    private Set<Integer> nextColumns(int column, int row) {
        if (manifold.isSplitterAt(row, column)) {
            return Set.of(column - 1, column + 1);
        }

        return Set.of(column);
    }
}