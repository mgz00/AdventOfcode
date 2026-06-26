package day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JunctionBoxTest {

    @Test
    void shouldParseJunctionBox() {
        JunctionBox box = JunctionBox.from("162,817,812");

        assertEquals(162, box.x());
        assertEquals(817, box.y());
        assertEquals(812, box.z());
    }

    @Test
    void shouldCalculateSquaredDistance() {
        JunctionBox first = new JunctionBox(0, 0, 0);
        JunctionBox second = new JunctionBox(3, 4, 12);

        assertEquals(169, first.squaredDistanceTo(second));
    }

    @Test
    void shouldRejectInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> JunctionBox.from("1,2"));
    }
}