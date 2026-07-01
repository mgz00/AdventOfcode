package sofware.aoc.day10;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class MachineParser {

    private static final Pattern LINE_PATTERN =
            Pattern.compile("\\[([.#]+)]\\s*(.*)\\s*\\{([\\d,]+)}");

    private static final Pattern BUTTON_PATTERN =
            Pattern.compile("\\(([^)]*)\\)");

    public Machine parse(String line) {
        Matcher matcher = LINE_PATTERN.matcher(line.trim());

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid machine: " + line);
        }

        long targetMask = parseTargetMask(matcher.group(1));
        List<Button> buttons = parseButtons(matcher.group(2));
        JoltageVector targetJoltage = parseTargetJoltage(matcher.group(3));

        return new Machine(targetMask, buttons, targetJoltage);
    }

    private long parseTargetMask(String lights) {
        return IntStream.range(0, lights.length())
                .filter(index -> lights.charAt(index) == '#')
                .mapToLong(index -> 1L << index)
                .reduce(0L, (a, b) -> a | b);
    }

    private List<Button> parseButtons(String text) {
        List<Button> buttons = new ArrayList<>();
        Matcher matcher = BUTTON_PATTERN.matcher(text);

        while (matcher.find()) {
            buttons.add(Button.from(matcher.group(1)));
        }

        return buttons;
    }

    private JoltageVector parseTargetJoltage(String text) {
        List<BigInteger> values = List.of(text.split(",")).stream()
                .map(String::trim)
                .map(BigInteger::new)
                .toList();

        return new JoltageVector(values);
    }
}