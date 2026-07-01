package sofware.aoc.day09;

public record TilePair(Tile first, Tile second) {

    public long area() {
        return first.rectangleAreaWith(second);
    }
}