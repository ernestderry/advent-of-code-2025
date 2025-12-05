package advent.of.code;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1b {

    String solve(List<String> puzzleInput) {
        int zeroCount = 0;
        int dial = 50;

        for (String rotation : puzzleInput) {
            Pattern pattern = Pattern.compile("([LR])(\\d+)");
            Matcher matcher = pattern.matcher(rotation);
            matcher.find();
            String direction = matcher.group(1);
            int clicks = Integer.parseInt(matcher.group(2));

            int move = "R".equals(direction) ? 1 : -1;
            for (int click = 0; click < clicks; click += 1) {
                dial += move;
                if (dial % 100 == 0) {
                    zeroCount += 1;
                }
            }
        }

        return Integer.toString(zeroCount);

    }
}
