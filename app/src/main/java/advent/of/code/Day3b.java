package advent.of.code;

import java.util.List;
import java.util.stream.IntStream;

public class Day3b {

    String solve(List<String> puzzleInput) {

        return String.valueOf(puzzleInput.stream()
            .mapToLong(bank -> getBankJoltage(bank, 12))
            .sum());            
    }

    private long getBankJoltage(String bank, int batteriesToUse) {
        long total = 0;
        int maxPos = -1;
        for (int b = batteriesToUse; b > 1; b--) {
            maxPos = positionOfLargestBatteryInRange(bank, maxPos + 1, bank.length() - batteriesToUse + 1);
            int digit = bank.charAt(maxPos) - '0';  
            total += digit * Math.pow(10, b-1);
        }

        int digit2 = IntStream.range(maxPos + 1, bank.length())
            .map(battery -> bank.charAt(battery) - '0')
            .max()
            .getAsInt();            

        return total + digit2;
    }

    private int positionOfLargestBatteryInRange(String bank, int start, int end) {
        int maxPos = start;
        int max = bank.charAt(0) - '0';
        for(int battery=1; battery < end; battery++) {
            int batteryPower = bank.charAt(battery) - '0';
            if (batteryPower > max) {
                max = batteryPower;
                maxPos = battery;
            }
        }     
        return maxPos;   
    }
}
