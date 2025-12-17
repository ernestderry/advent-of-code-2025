package advent.of.code;

import java.util.List;

public class Day5a {

    String solve(List<String> puzzleInput) {

        int delimeterPos = puzzleInput.indexOf("");
        List<String> freshRanges = puzzleInput.subList(0, delimeterPos);

        List<Range> ranges = freshRanges.stream()
            .map(range -> {
                String[] rangeElements = range.split("-");
                long min = Long.parseLong(rangeElements[0]);
                long max = Long.parseLong(rangeElements[1]);
                return new Range(min, max);
            }).toList();

        List<String> ids = puzzleInput.subList(delimeterPos + 1, puzzleInput.size());

        long freshTotal =  ids.stream()
            .filter(id -> inRange(id, ranges))
            .count();        

        return String.valueOf(freshTotal);
    }

    boolean inRange(String id, List<Range> ranges) {
        long idLong = Long.parseLong(id);
        return ranges.stream()
            .anyMatch(range -> idLong >= range.min && idLong <= range.max);
    }

    record Range(long min, long max) {};
}
