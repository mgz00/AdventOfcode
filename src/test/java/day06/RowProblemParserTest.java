package day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RowProblemParserTest {

    @Test
    void shouldParseProblemByRows() {
        List<String> lines = List.of(
                "123",
                " 45",
                "  6",
                "*  "
        );

        MathProblem problem = new RowProblemParser()
                .parse(lines, new ColumnRange(0, 3));

        assertEquals('*', problem.operator());
        assertEquals(List.of(123L, 45L, 6L), problem.numbers());
        assertEquals(33210, problem.compute());
    }
}