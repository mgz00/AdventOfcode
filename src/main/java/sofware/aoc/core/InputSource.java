package sofware.aoc.core;

import java.util.List;
import java.util.stream.Stream;

public interface InputSource {
    List<String> readAsLines();
    Stream<String> readAsStream();
    String readAsText();
}