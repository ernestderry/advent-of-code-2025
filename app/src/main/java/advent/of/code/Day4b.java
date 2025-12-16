package advent.of.code;

import java.util.ArrayList;
import java.util.List;

public class Day4b {

    char[][] grid;
    int totalRows;
    int totalColumns;

    String solve(List<String> puzzleInput) {
        totalRows = puzzleInput.size();
        totalColumns = puzzleInput.get(0).length();
        int totalRollsRemoved = 0;

        grid = puzzleInput.stream()
            .map(String::toCharArray)
            .toArray(char[][]::new);

        List<Coordinate> accessibleRolls = getAccessibleRolls();

        while (accessibleRolls.size() > 0) {
            accessibleRolls.stream()
                .forEach(rollCoordinates -> grid[rollCoordinates.row][rollCoordinates.column] = '.');
            totalRollsRemoved += accessibleRolls.size();
            accessibleRolls = getAccessibleRolls();
        }


        return String.valueOf(totalRollsRemoved); 
    }

    private List<Coordinate> getAccessibleRolls() {
        List<Coordinate> accessibleRolls = new ArrayList<Coordinate>();

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
                        accessibleRolls.add(new Coordinate(rowNo, colNo));
                    }
                }
            }
        }
        return accessibleRolls;
    }

    class Coordinate {
        int row;
        int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}

