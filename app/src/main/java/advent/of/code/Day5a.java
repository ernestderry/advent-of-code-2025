package advent.of.code;

import java.util.List;

public class Day5a {

    String solve(List<String> puzzleInput) {

        int delimeterPos = puzzleInput.indexOf("");
        List<String> freshRanges = puzzleInput.subList(0, delimeterPos);

        List<Range> ranges = freshRanges.stream()
            .map(Range::fromRange).toList();

        List<String> ids = puzzleInput.subList(delimeterPos + 1, puzzleInput.size());

        long freshTotal =  ids.stream()
            .filter(id -> inRange(id, ranges))
            .count();        

        return String.valueOf(freshTotal);
    }

    boolean inRange(String id, List<Range> ranges) {
        long idLong = Long.parseLong(id);

        return ranges.stream()
            .anyMatch(range -> range.contains(idLong));
    }

    record Range(long min, long max) {

        static Range fromRange(String range) {
            String[] parts = range.split("-");
            return new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1])); 
        }

        boolean contains(long id) {
            return id >= min && id <= max;
        }
    };
}
