package advent.of.code;

import java.util.List;

public class Day3b {

    String solve(List<String> puzzleInput) {

        return String.valueOf(puzzleInput.stream()
            .mapToLong(bank -> getBankJoltage(bank, 12))
            .sum());            
    }

    private long getBankJoltage(String bank, int batteriesToUse) {
        long total = 0;
        int maxPos = -1;
        for (int b = batteriesToUse; b > 0; b--) {
            maxPos = positionOfLargestBatteryInRange(bank, maxPos + 1, bank.length() - b + 1);
            int digit = bank.charAt(maxPos) - '0';  
            total += digit * Math.pow(10, b-1);
        }          

        return total;
    }

    private int positionOfLargestBatteryInRange(String bank, int start, int end) {
        int maxPos = start;
        int max = bank.charAt(start) - '0';
        for(int battery=start; battery < end; battery++) {
            int batteryPower = bank.charAt(battery) - '0';
            if (batteryPower > max) {
                max = batteryPower;
                maxPos = battery;
            }
        }     
        return maxPos;   
    }
}
