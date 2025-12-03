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

public class Day1aTest {

    Day1a day1a;

    @BeforeEach
    public void setup() {
        day1a = new Day1a();
    }

    @Test
    public void noMoves() {
        List<String> puzzleInput= List.of();
        assertEquals("0", day1a.solve(puzzleInput));
    }

    @Test
    public void rotateRightToZero() {
        List<String> puzzleInput= List.of("R50");
        assertEquals("1", day1a.solve(puzzleInput));
    }

    @Test
    public void rotateRightTo99() {
        List<String> puzzleInput= List.of("R49");
        assertEquals("0", day1a.solve(puzzleInput));
    }

    @Test
    public void rotateLeftToZero() {
        List<String> puzzleInput= List.of("L50");
        assertEquals("1", day1a.solve(puzzleInput));
    }

    @Test
    public void rotateLeftTo1() {
        List<String> puzzleInput= List.of("L49");
        assertEquals("0", day1a.solve(puzzleInput));
    }

    @Test
    public void rotateToZeroIn3StepsLeftAndRight() {
        List<String> puzzleInput= List.of("L60", "R20", "L10");
        assertEquals("1", day1a.solve(puzzleInput));
    }

    @Test
    public void rotateRightToZeroTwice() {
        List<String> puzzleInput= List.of("R50", "R10", "R90");
        assertEquals("2", day1a.solve(puzzleInput));
    }

    @Test
    public void rotateLeftToZeroThreeTimes() {
        List<String> puzzleInput= List.of("L50", "L300", "L20", "L80", "L10");
        assertEquals("3", day1a.solve(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day1a_example.txt"); 
        assertEquals("3", day1a.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day1a.txt"); 
        assertEquals("1158", day1a.solve(puzzleInput));
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
