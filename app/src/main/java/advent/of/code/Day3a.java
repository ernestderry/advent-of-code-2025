package advent.of.code;

import java.util.List;
import java.util.stream.IntStream;

public class Day3a {

    String solve(List<String> puzzleInput) {

        char[] bank = puzzleInput.get(0).toCharArray();

        int maxPos = 0;
        int max = Integer.parseInt(String.valueOf(bank[0]));
        for(int battery=1; battery < bank.length-1; battery++) {
            int batteryPower = Integer.parseInt(String.valueOf(bank[battery]));
            if (batteryPower > max) {
                max = batteryPower;
                maxPos = battery;
            }
        }
        int digit1 = Integer.parseInt(String.valueOf(bank[maxPos]));   

        int digit2 = IntStream.range(maxPos + 1, bank.length)
            .map(battery -> Integer.parseInt(String.valueOf(bank[battery])))
            .max()
            .getAsInt();
            

        return String.valueOf(digit1) + String.valueOf(digit2);
    }
}
