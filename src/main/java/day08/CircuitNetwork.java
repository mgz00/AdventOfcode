package day08;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class CircuitNetwork {

    private final List<JunctionBox> boxes;
    private final List<Connection> connections;

    public CircuitNetwork(List<JunctionBox> boxes) {
        this.boxes = List.copyOf(boxes);
        this.connections = generateConnections();
    }

    public long connectClosestAndMultiplyLargestCircuits(int connectionLimit) {
        DisjointSet disjointSet = new DisjointSet(boxes.size());

        connections.stream()
                .limit(connectionLimit)
                .forEach(connection ->
                        disjointSet.union(
                                connection.firstIndex(),
                                connection.secondIndex()
                        )
                );

        return disjointSet.productOfLargestComponents(3);
    }

    public long connectUntilSingleCircuitAndMultiplyLastXCoordinates() {
        DisjointSet disjointSet = new DisjointSet(boxes.size());

        for (Connection connection : connections) {
            boolean merged = disjointSet.union(
                    connection.firstIndex(),
                    connection.secondIndex()
            );

            if (merged && disjointSet.isFullyConnected()) {
                JunctionBox first = boxes.get(connection.firstIndex());
                JunctionBox second = boxes.get(connection.secondIndex());

                return first.x() * second.x();
            }
        }

        throw new IllegalStateException("Network could not be fully connected");
    }

    private List<Connection> generateConnections() {
        return IntStream.range(0, boxes.size())
                .boxed()
                .flatMap(first ->
                        IntStream.range(first + 1, boxes.size())
                                .mapToObj(second ->
                                        new Connection(
                                                first,
                                                second,
                                                boxes.get(first).squaredDistanceTo(boxes.get(second))
                                        )
                                )
                )
                .sorted(Comparator.comparingLong(Connection::squaredDistance))
                .toList();
    }
}