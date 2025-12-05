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

public class Day2bTest {

    Day2b day2b;

    @BeforeEach
    public void setup() {
        day2b = new Day2b();
    }

    @Test
    public void singleRangeWithOneInvalidId() {
        List<String> puzzleInput = List.of("446443-446449");
        assertEquals("446446", day2b.solve(puzzleInput));
    }

    @Test
    public void singleRangeWithTwoInvalidIds() {
        List<String> puzzleInput = List.of("11-22");
        assertEquals("33", day2b.solve(puzzleInput));
    }

    @Test
    public void rangeWithoutAnInvalidId() {
        List<String> puzzleInput = List.of("12-21");
        assertEquals("0", day2b.solve(puzzleInput));
    }

    @Test
    public void multipleRangesWithInvalidIds() {
        List<String> puzzleInput = List.of("446443-446449,11-22");
        assertEquals("446479", day2b.solve(puzzleInput));
    }    

    @Test
    public void anyLengthStringRepeatedAtLeastTwice2() {
        List<String> puzzleInput = List.of("998-1012");   //999 and 1010
        assertEquals("2009", day2b.solve(puzzleInput));
    }

    @Test
    public void anyLengthStringRepeatedAtLeastTwice3() {
        List<String> puzzleInput = List.of("565653-565659");
        assertEquals("565656", day2b.solve(puzzleInput));
    }

    @Test
    public void anyLengthStringRepeatedAtLeastTwice4() {
        List<String> puzzleInput = List.of("824824821-824824827");
        assertEquals("824824824", day2b.solve(puzzleInput));
    }

    @Test
    public void anyLengthStringRepeatedAtLeastTwice5() {
        List<String> puzzleInput = List.of("2121212118-2121212124");
        assertEquals("2121212121", day2b.solve(puzzleInput));
    }

    @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2_example.txt"); 
        assertEquals("4174379265", day2b.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2.txt"); 
        assertEquals("44143124633", day2b.solve(puzzleInput));
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
