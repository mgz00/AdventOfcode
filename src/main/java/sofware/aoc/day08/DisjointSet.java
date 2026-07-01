package sofware.aoc.day08;

import java.util.Comparator;
import java.util.stream.IntStream;

public class DisjointSet {

    private final int[] parent;
    private final int[] size;
    private int components;

    public DisjointSet(int elements) {
        this.parent = IntStream.range(0, elements).toArray();
        this.size = IntStream.generate(() -> 1)
                .limit(elements)
                .toArray();
        this.components = elements;
    }

    public boolean union(int first, int second) {
        int firstRoot = find(first);
        int secondRoot = find(second);

        if (firstRoot == secondRoot) {
            return false;
        }

        if (size[firstRoot] < size[secondRoot]) {
            parent[firstRoot] = secondRoot;
            size[secondRoot] += size[firstRoot];
        } else {
            parent[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
        }

        components--;
        return true;
    }

    public boolean isFullyConnected() {
        return components == 1;
    }

    public long productOfLargestComponents(int amount) {
        return IntStream.range(0, parent.length)
                .filter(index -> parent[index] == index)
                .map(index -> size[index])
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(amount)
                .mapToLong(Integer::longValue)
                .reduce(1, (a, b) -> a * b);
    }

    private int find(int element) {
        if (parent[element] != element) {
            parent[element] = find(parent[element]);
        }

        return parent[element];
    }
}