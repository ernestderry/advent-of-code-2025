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

        while (!accessibleRolls.isEmpty()) {
            accessibleRolls.forEach(rollCoordinates -> grid[rollCoordinates.row][rollCoordinates.column] = '.');
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
                    if (countNeighbours(rowNo, colNo) <= 3) {
                        accessibleRolls.add(new Coordinate(rowNo, colNo));
                    }
                }
            }
        }
        return accessibleRolls;
    }

    private int countNeighbours(int rowNo, int colNo) {
        int neighbours = 0;
        for (int horizontalDirection = -1; horizontalDirection <= 1; horizontalDirection++) {
            for (int verticalDirection = -1; verticalDirection <= 1; verticalDirection++) {
                int neighbourColumn = colNo + horizontalDirection;
                int neighbourRow = rowNo + verticalDirection;
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
        return neighbours;
    }

    record Coordinate (int row, int column) {};
}

