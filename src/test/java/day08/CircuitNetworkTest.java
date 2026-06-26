package day08;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircuitNetworkTest {

    @Test
    void shouldConnectClosestPairsAndMultiplyLargestComponents() {
        CircuitNetwork network = new CircuitNetwork(exampleBoxes());

        assertEquals(40, network.connectClosestAndMultiplyLargestCircuits(10));
    }

    @Test
    void shouldConnectUntilSingleCircuitAndMultiplyLastXCoordinates() {
        CircuitNetwork network = new CircuitNetwork(exampleBoxes());

        assertEquals(25272, network.connectUntilSingleCircuitAndMultiplyLastXCoordinates());
    }

    private List<JunctionBox> exampleBoxes() {
        return List.of(
                new JunctionBox(162, 817, 812),
                new JunctionBox(57, 618, 57),
                new JunctionBox(906, 360, 560),
                new JunctionBox(592, 479, 940),
                new JunctionBox(352, 342, 300),
                new JunctionBox(466, 668, 158),
                new JunctionBox(542, 29, 236),
                new JunctionBox(431, 825, 988),
                new JunctionBox(739, 650, 466),
                new JunctionBox(52, 470, 668),
                new JunctionBox(216, 146, 977),
                new JunctionBox(819, 987, 18),
                new JunctionBox(117, 168, 530),
                new JunctionBox(805, 96, 715),
                new JunctionBox(346, 949, 466),
                new JunctionBox(970, 615, 88),
                new JunctionBox(941, 993, 340),
                new JunctionBox(862, 61, 35),
                new JunctionBox(984, 92, 344),
                new JunctionBox(425, 690, 689)
        );
    }
}