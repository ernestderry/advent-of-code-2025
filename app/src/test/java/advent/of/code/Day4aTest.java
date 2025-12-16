package advent.of.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day4aTest {

    Day4a day4a;

    @BeforeEach
    public void setup() {
        day4a = new Day4a();
    }

    @Test
    public void emptyGrid() throws IOException {
        List<String> puzzleInput = List.of("."); 
        assertEquals("0", day4a.solve(puzzleInput));
    }

    @Test
    public void singleRoll() throws IOException {
        List<String> puzzleInput = List.of("@"); 
        assertEquals("1", day4a.solve(puzzleInput));
    }

    @Test
    public void threeRolls() throws IOException {
        List<String> puzzleInput = List.of("@@@"); 
        assertEquals("3", day4a.solve(puzzleInput));
    }

    @Test
    public void twoRowsOfRolls() throws IOException {
        List<String> puzzleInput = List.of(
            "@.@",
            "@.@"); 
        assertEquals("4", day4a.solve(puzzleInput));
    }

    @Test
    public void oneRollHasTooManyNeighbours() throws IOException {
        List<String> puzzleInput = List.of(
            "@@@",
            "@.@"); 
        assertEquals("4", day4a.solve(puzzleInput));
    }

    @Test
    public void oneRollHasTooManyNeighbours2() throws IOException {
        List<String> puzzleInput = List.of(
            "@.@",
            "@@@"); 
        assertEquals("4", day4a.solve(puzzleInput));
    }

    @Test
    public void oneRollHasTooManyNeighbours3() throws IOException {
        List<String> puzzleInput = List.of(
            "@.@",
            ".@.",
            "@@."); 
        assertEquals("4", day4a.solve(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day4_example.txt"); 
        assertEquals("13", day4a.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day4.txt"); 
        assertEquals("1491", day4a.solve(puzzleInput));
    }

    private List<String> readPuzzleInputFromFile(String filename) throws FileNotFoundException, IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) { 
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found!");
            }
            return new BufferedReader(new InputStreamReader(inputStream)).lines().toList(); 
        }
    }
}
