package day12;

import java.util.ArrayList;
import java.util.List;

public class FarmParser {

    private final List<GiftShape> shapes = new ArrayList<>();
    private final List<RegionRequest> regions = new ArrayList<>();

    public void parse(List<String> lines) {
        List<String> shapeLines = new ArrayList<>();
        boolean readingShapes = true;

        for (String line : lines) {
            String clean = line.trim();

            if (clean.isEmpty()) {
                continue;
            }

            if (isRegionLine(clean)) {
                readingShapes = false;
                addPendingShape(shapeLines);
                regions.add(RegionRequest.from(clean));
                continue;
            }

            if (readingShapes && clean.endsWith(":")) {
                addPendingShape(shapeLines);
            } else if (readingShapes) {
                shapeLines.add(clean);
            }
        }

        addPendingShape(shapeLines);
    }

    public List<GiftShape> shapes() {
        return List.copyOf(shapes);
    }

    public List<RegionRequest> regions() {
        return List.copyOf(regions);
    }

    private boolean isRegionLine(String line) {
        return line.matches("\\d+x\\d+:.*");
    }

    private void addPendingShape(List<String> shapeLines) {
        if (!shapeLines.isEmpty()) {
            shapes.add(GiftShape.fromLines(shapeLines));
            shapeLines.clear();
        }
    }
}