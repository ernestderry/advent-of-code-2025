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

public class Day5aTest {

    Day5a day5a;

    @BeforeEach
    public void setup() {
        day5a = new Day5a();
    }

    @Test
    public void oneRangeAndIdNotInRange() {
        List<String> puzzleInput = List.of("1-3","","4");
        assertEquals("0", day5a.solve(puzzleInput));        
    }

    @Test
    public void oneRangeAndIdInRange() {
        List<String> puzzleInput = List.of("1-3","","2");
        assertEquals("1", day5a.solve(puzzleInput));        
    }

    @Test
    public void oneRangeAndMultipleIdsInRange() {
        List<String> puzzleInput = List.of("1-3","","1","2","3","4");
        assertEquals("3", day5a.solve(puzzleInput));        
    }

    @Test
    public void twoRangesAndMultipleIdsInRanges() {
        List<String> puzzleInput = List.of("1-30","20-60","","1","29","30","100");
        assertEquals("3", day5a.solve(puzzleInput));        
    }

    @Test
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day5_example.txt"); 
        assertEquals("3", day5a.solve(puzzleInput));
    }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day5.txt"); 
        assertEquals("679", day5a.solve(puzzleInput));
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
