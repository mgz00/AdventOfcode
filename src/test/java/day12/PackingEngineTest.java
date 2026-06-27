package day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackingEngineTest {

    @Test
    void shouldFitTwoExampleShapesInFourByFourRegion() {
        GiftShape shape = GiftShape.fromLines(List.of(
                "###",
                "#..",
                "###"
        ));

        PackingEngine engine = new PackingEngine(4, 4);

        assertTrue(engine.canFit(List.of(shape, shape)));
    }

    @Test
    void shouldRejectWhenAreaIsTooLarge() {
        GiftShape shape = GiftShape.fromLines(List.of(
                "###",
                "###",
                "###"
        ));

        PackingEngine engine = new PackingEngine(2, 2);

        assertFalse(engine.canFit(List.of(shape)));
    }
}