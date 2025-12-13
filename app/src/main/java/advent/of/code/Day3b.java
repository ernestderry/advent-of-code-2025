package advent.of.code;

import java.util.List;

public class Day3b {

    String solve(List<String> puzzleInput) {

        return String.valueOf(puzzleInput.stream()
            .mapToLong(bank -> getBankJoltage(bank, 12))
            .sum());            
    }

    private long getBankJoltage(String bank, int batteriesToUse) {
        int currentPos = 0;
        StringBuilder result = new StringBuilder();
        for (int b = batteriesToUse; b > 0; b--) {
            // if the number of batteries remainng equals the number of batteries still to collect
            if (bank.length() - currentPos == b) {
                // collect them all in one go
                result.append(bank.substring(currentPos));
                break;  
            } else {
                // else take the largest one from the range of surplus batteries to the amount left to collect
                int end = bank.length() - b + 1;
                currentPos = positionOfLargestBatteryInRange(bank, currentPos, end);
                result.append(bank.charAt(currentPos));  
                currentPos += 1;
            }
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
