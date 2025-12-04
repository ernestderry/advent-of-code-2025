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

public class Day2aTest {

    Day2a day2a;

    @BeforeEach
    public void setup() {
        day2a = new Day2a();
    }

    @Test
    public void oddNumberOfDigitRangesAreValid() {
        List<String> puzzleInput = List.of("110-119");
        assertEquals("0", day2a.solve(puzzleInput));
    }

    @Test
    public void singleRangeWithOneInvalidId() {
        List<String> puzzleInput = List.of("446443-446449");
        assertEquals("446446", day2a.solve(puzzleInput));
    }

    @Test
    public void singleRangeWithTwoInvalidIds() {
        List<String> puzzleInput = List.of("11-22");
        assertEquals("33", day2a.solve(puzzleInput));
    }

    @Test
    public void rangeWithoutAnInvalidId() {
        List<String> puzzleInput = List.of("12-21");
        assertEquals("0", day2a.solve(puzzleInput));
    }

    @Test
    public void multipleRangesWithInvalidIds() {
        List<String> puzzleInput = List.of("446443-446449,11-22");
        assertEquals("446479", day2a.solve(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2a_example.txt"); 
        assertEquals("1227775554", day2a.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2.txt"); 
        assertEquals("23560874270", day2a.solve(puzzleInput));
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
