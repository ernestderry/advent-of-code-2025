package advent.of.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Day2a extends Solution {

    Day2a() {
        super.day = 2;
        super.part = "a";
    }

    String solve(List<String> puzzleInput) {

        List<String> ranges = Arrays.asList(puzzleInput.get(0).split(","));
        return String.valueOf(ranges.stream()
            .collect(Collectors.summingLong(range -> sumInvalidIdsInRange(range))));
    }

    private long sumInvalidIdsInRange(String range) {
        long start = Long.valueOf(range.split("-")[0]);
        long end = Long.valueOf(range.split("-")[1]);

        return LongStream.range(start, end + 1)
            .filter(id -> isInvalidId(String.valueOf(id)))
            .sum();
    }

    private boolean isInvalidId(String id) {
        if (id.length() % 2 != 0) {
            return false;
        }

        String part1 = id.substring(0, id.length() / 2);
        String part2 = id.substring(id.length() / 2, id.length());

        if (part1.equals(part2)) {
            return true;
        }

        return false;
    }

}
