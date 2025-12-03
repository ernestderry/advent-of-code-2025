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
    public void examplePuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day2a_example.txt"); 
        assertEquals("", day2a.solve(puzzleInput));
    }

    // @Test
    // public void actualPuzzleInput() throws IOException {
    //     List<String> puzzleInput = readPuzzleInputFromFile("dayX.txt"); 
    //     assertEquals("", dayX.solve(puzzleInput));
    // }

    private List<String> readPuzzleInputFromFile(String filename) throws FileNotFoundException, IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) { 
            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found!");
            }
            return new BufferedReader(new InputStreamReader(inputStream)).lines().toList(); 
        }
    }
}
