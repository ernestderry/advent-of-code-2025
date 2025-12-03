package advent.of.code;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1a extends Solution {

    Day1a() {
        super.day = 0;
        super.part = "a";
    }

    String solve(List<String> puzzleInput) {
        int zeroCount = 0;
        int dial = 50;

        for (String rotation : puzzleInput) {
            Pattern pattern = Pattern.compile("([LR])(\\d+)");
            Matcher matcher = pattern.matcher(rotation);
            matcher.find();
            String direction = matcher.group(1);
            int clicks = Integer.parseInt(matcher.group(2));

            if ("R".equals(direction)) {
                dial += clicks;
                if (dial == 100) {
                    zeroCount += 1;
                }
            } else {
                dial -= clicks;
                if (dial == 0) {
                    zeroCount += 1;
                }
            }
        }

        return Integer.toString(zeroCount);

    }
}
