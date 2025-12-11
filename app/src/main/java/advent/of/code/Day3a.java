package advent.of.code;

import java.util.List;
import java.util.stream.IntStream;

public class Day3a {

    String solve(List<String> puzzleInput) {

        return String.valueOf(puzzleInput.stream()
            .mapToInt(bank -> getBankJoltage(bank))
            .sum());            
    }

    private int getBankJoltage(String bank) {
        int maxPos = 0;
        int max = bank.charAt(0) - '0';
        for(int battery=1; battery < bank.length() - 1; battery++) {
            int batteryPower = bank.charAt(battery) - '0';
            if (batteryPower > max) {
                max = batteryPower;
                maxPos = battery;
            }
        }
        int digit1 = max;   

        int digit2 = IntStream.range(maxPos + 1, bank.length())
            .map(battery -> bank.charAt(battery) - '0')
            .max()
            .getAsInt();            

        return digit1 * 10 + digit2;
    }
}
