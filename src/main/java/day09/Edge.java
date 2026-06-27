package day09;

public record Edge(Tile start, Tile end) {

    public boolean isVertical() {
        return start.x() == end.x();
    }

    public boolean isHorizontal() {
        return start.y() == end.y();
    }

    public int minX() {
        return Math.min(start.x(), end.x());
    }

    public int maxX() {
        return Math.max(start.x(), end.x());
    }

    public int minY() {
        return Math.min(start.y(), end.y());
    }

    public int maxY() {
        return Math.max(start.y(), end.y());
    }

    public boolean contains(Tile tile) {
        if (isVertical()) {
            return tile.x() == start.x()
                    && tile.y() >= minY()
                    && tile.y() <= maxY();
        }

        if (isHorizontal()) {
            return tile.y() == start.y()
                    && tile.x() >= minX()
                    && tile.x() <= maxX();
        }

        return false;
    }

    public double intersectXAt(int y) {
        return (double) (end.x() - start.x())
                * (y - start.y())
                / (end.y() - start.y())
                + start.x();
    }
}