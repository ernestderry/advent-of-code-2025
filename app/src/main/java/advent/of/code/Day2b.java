package advent.of.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

        int groupSize = id.length() / parts;

        List<String> groups = new ArrayList<String>();
        for(int group = 0; group < parts; group++) {
            groups.add(id.substring(group * groupSize, (group + 1) * groupSize));
        }

        String firstGroup = groups.get(0);
        return groups.stream()
            .allMatch(group -> group.equals(firstGroup));
            
    }

}
