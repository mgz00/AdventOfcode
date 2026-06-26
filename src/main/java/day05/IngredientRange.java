package day05;

public record IngredientRange(long start, long end) implements Comparable<IngredientRange> {

    public IngredientRange {
        if (start > end) {
            throw new IllegalArgumentException("Range start cannot be greater than range end");
        }
    }

    public static IngredientRange from(String text) {
        String[] parts = text.trim().split("-");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid range: " + text);
        }

        return new IngredientRange(
                Long.parseLong(parts[0]),
                Long.parseLong(parts[1])
        );
    }

    public boolean contains(long ingredientId) {
        return ingredientId >= start && ingredientId <= end;
    }

    public boolean canMergeWith(IngredientRange other) {
        return other.start <= this.end + 1;
    }

    public IngredientRange mergeWith(IngredientRange other) {
        return new IngredientRange(
                Math.min(this.start, other.start),
                Math.max(this.end, other.end)
        );
    }

    public long length() {
        return end - start + 1;
    }

    @Override
    public int compareTo(IngredientRange other) {
        return Long.compare(this.start, other.start);
    }
}