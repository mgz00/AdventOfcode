package day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisjointSetTest {

    @Test
    void shouldMergeComponents() {
        DisjointSet set = new DisjointSet(4);

        assertTrue(set.union(0, 1));
        assertFalse(set.union(0, 1));
    }

    @Test
    void shouldDetectFullyConnectedSet() {
        DisjointSet set = new DisjointSet(3);

        assertFalse(set.isFullyConnected());

        set.union(0, 1);
        assertFalse(set.isFullyConnected());

        set.union(1, 2);
        assertTrue(set.isFullyConnected());
    }

    @Test
    void shouldCalculateProductOfLargestComponents() {
        DisjointSet set = new DisjointSet(5);

        set.union(0, 1);
        set.union(2, 3);

        assertEquals(4, set.productOfLargestComponents(3));
    }
}