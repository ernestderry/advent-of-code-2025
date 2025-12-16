package advent.of.code;

import java.util.List;

public class Day4a {

    char[][] grid;
    int totalRows;
    int totalColumns;

    String solve(List<String> puzzleInput) {
        totalRows = puzzleInput.size();
        totalColumns = puzzleInput.get(0).length();
        int total = 0;

        grid = puzzleInput.stream()
            .map(String::toCharArray)
            .toArray(char[][]::new);

        for (int rowNo = 0; rowNo < totalRows; rowNo++ ) {
            for (int colNo = 0; colNo < totalColumns; colNo++) {
                if (grid[rowNo][colNo]== '@') {
                    int neighbours = 0;
                    neighbours += check(rowNo + 1, colNo);
                    neighbours += check(rowNo - 1, colNo);
                    neighbours += check(rowNo, colNo + 1);
                    neighbours += check(rowNo, colNo - 1);
                    neighbours += check(rowNo + 1, colNo - 1);
                    neighbours += check(rowNo + 1, colNo + 1);
                    neighbours += check(rowNo - 1, colNo - 1);
                    neighbours += check(rowNo - 1, colNo + 1);
                    if (neighbours <= 3) {
                        total += 1;
                        System.out.println(rowNo + " " + colNo);
                    }
                }
            }
        }
        return String.valueOf(total); 
    }

    private int check(int rowNo, int colNo) {
        if (rowNo < 0 || rowNo >= totalRows) {
            return 0;
        }

        if (colNo < 0 || colNo >= totalColumns) {
            return 0;
        }

        if (grid[rowNo][colNo] == '@') {
            return 1;
        }

        return 0;
    }
}

