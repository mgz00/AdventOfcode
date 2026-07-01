package sofware.aoc.day10;

import java.util.List;

public record Machine(
        long targetMask,
        List<Button> buttons,
        JoltageVector targetJoltage
) {
    public Machine {
        buttons = List.copyOf(buttons);
    }
}