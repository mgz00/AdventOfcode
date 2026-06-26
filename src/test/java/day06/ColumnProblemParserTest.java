package day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColumnProblemParserTest {

    @Test
    void shouldParseProblemByColumns() {
        List<String> lines = List.of(
                "123",
                " 45",
                "  6",
                "*  "
        );

        MathProblem problem = new ColumnProblemParser()
                .parse(lines, new ColumnRange(0, 3));

        assertEquals('*', problem.operator());
        assertEquals(List.of(356L, 24L, 1L), problem.numbers());
        assertEquals(8544, problem.compute());
    }
}