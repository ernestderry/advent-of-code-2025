package advent.of.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Day2b extends Solution {

    Day2b() {
        super.day = 2;
        super.part = "b";
    }

    String solve(List<String> puzzleInput) {

        List<String> ranges = Arrays.asList(puzzleInput.get(0).split(","));
        return String.valueOf(ranges.stream()
            .mapToLong(range -> sumInvalidIdsInRange(range))
            .sum());
    }

    private long sumInvalidIdsInRange(String range) {
        long start = Long.valueOf(range.split("-")[0]);
        long end = Long.valueOf(range.split("-")[1]);

        return LongStream.range(start, end + 1)
            .filter(id -> isInvalidId(String.valueOf(id)))
            .sum();
    }

    private boolean isInvalidId(String id) {
        return IntStream.range(1, id.length() / 2 + 1)
            .anyMatch(i -> isInvalidId(id, i));            
    }

    private boolean isInvalidId(String id, int groupSize) {
        if (id.length() % groupSize != 0) {
            return false;
        }

        int numGroups = id.length() / groupSize;
        if (numGroups < 2) {
            return false;
        }

        List<String> groups = new ArrayList<String>();
        for(int group = 0; group < numGroups; group++) {
            groups.add(id.substring(group * groupSize, (group + 1) * groupSize));
        }

        String firstGroup = groups.get(0);
        return groups.stream()
            .allMatch(group -> group.equals(firstGroup));

    }
}
