package day07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BeamSimulationTest {

    @Test
    void shouldCountSimpleSplit() {
        TachyonManifold manifold = new TachyonManifold(List.of(
                "..S..",
                "..^..",
                "....."
        ));

        BeamSimulation simulation = new BeamSimulation(manifold);

        assertEquals(1, simulation.countSplits());
        assertEquals(2, simulation.countTimelines());
    }

    @Test
    void shouldMergeBeamsForPartOneButKeepTimelinesForPartTwo() {
        TachyonManifold manifold = new TachyonManifold(List.of(
                "..S..",
                "..^..",
                ".^.^.",
                "....."
        ));

        BeamSimulation simulation = new BeamSimulation(manifold);

        assertEquals(3, simulation.countSplits());
        assertEquals(4, simulation.countTimelines());
    }
}