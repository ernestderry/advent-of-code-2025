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
                    for (int horizontalDirection = -1; horizontalDirection <= 1; horizontalDirection++) {
                        for (int verticalDirection = -1; verticalDirection <= 1; verticalDirection++) {
                            int neighbourRow = rowNo + horizontalDirection;
                            int neighbourColumn = colNo + verticalDirection;
                            if (neighbourRow < 0 || neighbourColumn < 0 ||
                                neighbourRow >= totalRows || neighbourColumn >= totalColumns) {
                                continue;
                            }

                            if (neighbourRow == rowNo && neighbourColumn == colNo) {
                                continue;
                            }

                            if (grid[neighbourRow][neighbourColumn] == '@') {
                                neighbours += 1;
                            }   
                                                 
                        }
                    }
                    if (neighbours <= 3) {
                        total += 1;
                    }
                }
            }
        }
        return String.valueOf(total); 
    }
}

