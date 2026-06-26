package day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorksheetParserTest {

    @Test
    void shouldParseMultipleProblemsByRows() {
        List<String> lines = List.of(
                "123 328",
                " 45 64 ",
                "  6 98 ",
                "*   +  "
        );

        Worksheet worksheet = new WorksheetParser()
                .parse(lines, new RowProblemParser());

        assertEquals(2, worksheet.problems().size());
        assertEquals(33700, worksheet.grandTotal());
    }
}