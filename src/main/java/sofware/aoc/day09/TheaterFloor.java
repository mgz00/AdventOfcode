package sofware.aoc.day09;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TheaterFloor {

    private final List<Tile> redTiles;

    public TheaterFloor(List<Tile> redTiles) {
        this.redTiles = List.copyOf(redTiles);
    }

    public long largestRectangleArea() {
        return tilePairs()
                .mapToLong(TilePair::area)
                .max()
                .orElse(0);
    }

    public long largestValidRectangleArea() {
        return tilePairs()
                .filter(this::isValidRectangle)
                .mapToLong(TilePair::area)
                .max()
                .orElse(0);
    }

    private boolean isValidRectangle(TilePair pair) {
        int minX = Math.min(pair.first().x(), pair.second().x());
        int maxX = Math.max(pair.first().x(), pair.second().x());
        int minY = Math.min(pair.first().y(), pair.second().y());
        int maxY = Math.max(pair.first().y(), pair.second().y());

        Tile cornerA = new Tile(minX, minY);
        Tile cornerB = new Tile(minX, maxY);
        Tile cornerC = new Tile(maxX, minY);
        Tile cornerD = new Tile(maxX, maxY);

        boolean cornersAreInside =
                Stream.of(cornerA, cornerB, cornerC, cornerD)
                        .allMatch(this::isInsideOrOnBoundary);

        return cornersAreInside
                && !hasBoundaryCrossingInterior(minX, maxX, minY, maxY);
    }

    private boolean isInsideOrOnBoundary(Tile tile) {
        return isOnBoundary(tile) || isStrictlyInside(tile);
    }

    private boolean isOnBoundary(Tile tile) {
        return edges().anyMatch(edge -> edge.contains(tile));
    }

    private boolean isStrictlyInside(Tile tile) {
        long intersections = edges()
                .filter(edge -> edge.isVertical())
                .filter(edge -> edge.minY() <= tile.y() && tile.y() < edge.maxY())
                .filter(edge -> tile.x() < edge.start().x())
                .count();

        return intersections % 2 == 1;
    }

    private boolean hasBoundaryCrossingInterior(int minX, int maxX, int minY, int maxY) {
        return edges().anyMatch(edge ->
                edge.isVertical()
                        && edge.start().x() > minX
                        && edge.start().x() < maxX
                        && Math.max(minY, edge.minY()) < Math.min(maxY, edge.maxY())
                        ||
                        edge.isHorizontal()
                                && edge.start().y() > minY
                                && edge.start().y() < maxY
                                && Math.max(minX, edge.minX()) < Math.min(maxX, edge.maxX())
        );
    }

    private Stream<TilePair> tilePairs() {
        return IntStream.range(0, redTiles.size())
                .boxed()
                .flatMap(first ->
                        IntStream.range(first + 1, redTiles.size())
                                .mapToObj(second ->
                                        new TilePair(
                                                redTiles.get(first),
                                                redTiles.get(second)
                                        )
                                )
                );
    }

    private Stream<Edge> edges() {
        return IntStream.range(0, redTiles.size())
                .mapToObj(index ->
                        new Edge(
                                redTiles.get(index),
                                redTiles.get((index + 1) % redTiles.size())
                        )
                );
    }
}