package sofware.aoc.core;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileInputSource implements InputSource {

    private final String filename;

    public FileInputSource(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> readAsLines() {
        try {
            return Files.readAllLines(getPath());
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Error reading lines from file: " + filename, e);
        }
    }

    @Override
    public Stream<String> readAsStream() {
        try {
            return Files.lines(getPath());
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Error opening stream from file: " + filename, e);
        }
    }

    @Override
    public String readAsText() {
        try {
            return Files.readString(getPath());
        } catch (IOException | URISyntaxException e) {
            throw new IllegalStateException("Error reading text from file: " + filename, e);
        }
    }

    private Path getPath() throws URISyntaxException {
        var resource = getClass().getClassLoader().getResource(filename);

        if (resource == null) {
            throw new IllegalArgumentException("Input file not found: " + filename);
        }

        return Path.of(resource.toURI());
    }
}
