package day08;

public record JunctionBox(long x, long y, long z) {

    public static JunctionBox from(String line) {
        String[] parts = line.trim().split(",");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid junction box: " + line);
        }

        return new JunctionBox(
                Long.parseLong(parts[0]),
                Long.parseLong(parts[1]),
                Long.parseLong(parts[2])
        );
    }

    public long squaredDistanceTo(JunctionBox other) {
        long dx = x - other.x;
        long dy = y - other.y;
        long dz = z - other.z;

        return dx * dx + dy * dy + dz * dz;
    }
}