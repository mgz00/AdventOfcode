package sofware.aoc.day11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReactorNetwork {

    private final Map<String, Device> devices;
    private final Map<String, Long> memo;

    public ReactorNetwork(List<Device> devices) {
        this.devices = devices.stream()
                .collect(Collectors.toUnmodifiableMap(
                        Device::name,
                        Function.identity()
                ));

        this.memo = new HashMap<>();
    }

    public long countPaths(String start, String end) {
        memo.clear();
        return countPathsFrom(start, end);
    }

    public long countPathsVisitingBoth(
            String start,
            String end,
            String firstRequired,
            String secondRequired
    ) {
        long firstOrder =
                countPaths(start, firstRequired)
                        * countPaths(firstRequired, secondRequired)
                        * countPaths(secondRequired, end);

        long secondOrder =
                countPaths(start, secondRequired)
                        * countPaths(secondRequired, firstRequired)
                        * countPaths(firstRequired, end);

        return firstOrder + secondOrder;
    }

    private long countPathsFrom(String current, String end) {
        if (current.equals(end)) {
            return 1;
        }

        if (memo.containsKey(current)) {
            return memo.get(current);
        }

        Device device = devices.get(current);

        if (device == null) {
            return 0;
        }

        long paths = device.outputs().stream()
                .mapToLong(next -> countPathsFrom(next, end))
                .sum();

        memo.put(current, paths);

        return paths;
    }
}