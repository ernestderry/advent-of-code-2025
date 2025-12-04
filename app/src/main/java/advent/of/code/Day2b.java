package advent.of.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Day2b extends Solution {

    Day2b() {
        super.day = 2;
        super.part = "b";
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
            .filter(id -> isInvalidId(String.valueOf(id), 2))
            .sum();
    }

    private boolean isInvalidId(String id, int parts) {
        if (id.length() % parts != 0) {
            return false;
        }

        List<String> groups = new ArrayList<String>();
        for(int group = 0; group < parts; group++) {
            groups.add(id.substring(group * parts, (group + 1) * parts));
        }

        String firstGroup = groups.get(0);
        return groups.stream()
            .allMatch(group -> group.equals(firstGroup));
            

        // String part1 = id.substring(0, id.length() / parts);
        // String part2 = id.substring(id.length() / parts, id.length());

        // if (part1.equals(part2)) {
        //     return true;
        // }

        // return false;
    }

}
