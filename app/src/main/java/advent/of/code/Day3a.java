package advent.of.code;

import java.util.List;
import java.util.stream.IntStream;

public class Day3a {

    String solve(List<String> puzzleInput) {

        return String.valueOf(puzzleInput.stream()
            .mapToInt(bank -> getBankJoltage(bank))
            .sum());
            
    }

    private Integer getBankJoltage(String bank) {
        char[] batteries = bank.toCharArray();
        int maxPos = 0;
        int max = Integer.parseInt(String.valueOf(batteries[0]));
        for(int battery=1; battery < batteries.length-1; battery++) {
            int batteryPower = Integer.parseInt(String.valueOf(batteries[battery]));
            if (batteryPower > max) {
                max = batteryPower;
                maxPos = battery;
            }
        }
        int digit1 = Integer.parseInt(String.valueOf(batteries[maxPos]));   

        int digit2 = IntStream.range(maxPos + 1, batteries.length)
            .map(battery -> Integer.parseInt(String.valueOf(batteries[battery])))
            .max()
            .getAsInt();            

        return Integer.parseInt(String.valueOf(digit1) + String.valueOf(digit2));
    }
}
