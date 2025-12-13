package advent.of.code;

import java.util.List;

public class Day3b {

    String solve(List<String> puzzleInput) {

        return String.valueOf(puzzleInput.stream()
            .mapToLong(bank -> getBankJoltage(bank, 12))
            .sum());            
    }

    private long getBankJoltage(String bank, int batteriesToUse) {
        int maxPos = -1;
        StringBuilder result = new StringBuilder();
        for (int b = batteriesToUse; b > 0; b--) {
            int start = maxPos + 1;
            int end = bank.length() - b + 1;
            if (start == end) {
                maxPos = start;
                result.append(bank.substring(maxPos));
                break;  
            } else {
                maxPos = positionOfLargestBatteryInRange(bank, start, end);
            }
            result.append(bank.charAt(maxPos));  
        }          

        return Long.parseLong(result.toString());
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
