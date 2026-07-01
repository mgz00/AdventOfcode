package sofware.aoc.day12;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FarmParserTest {

    @Test
    void shouldParseShapesAndRegions() {
        FarmParser parser = new FarmParser();

        parser.parse(List.of(
                "0:",
                "###",
                "##.",
                "##.",
                "",
                "1:",
                "###",
                "##.",
                ".##",
                "",
                "4x4: 2 0",
                "12x5: 1 1"
        ));

        assertEquals(2, parser.shapes().size());
        assertEquals(2, parser.regions().size());
        assertEquals(4, parser.regions().get(0).width());
        assertEquals(4, parser.regions().get(0).height());
    }
}