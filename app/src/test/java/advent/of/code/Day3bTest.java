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

public class Day3bTest {

    Day3b day3b;

    @BeforeEach
    public void setup() {
        day3b = new Day3b();
    }

    @Test
    public void test1() throws IOException {
        List<String> puzzleInput = List.of("987654321111111");
        assertEquals("987654321111", day3b.solve(puzzleInput));
    }

    @Test
    public void test2() throws IOException {
        List<String> puzzleInput = List.of("811111111111119");
        assertEquals("811111111119", day3b.solve(puzzleInput));
    }

    @Test
    public void test3() throws IOException {
        List<String> puzzleInput = List.of("234234234234278");
        assertEquals("434234234278", day3b.solve(puzzleInput));
    }

    // @Test
    public void test4() throws IOException {
        List<String> puzzleInput = List.of("818181911112111");
        assertEquals("92", day3b.solve(puzzleInput));
    }

    // @Test
    // public void twoBanksAreAddedTogether() throws IOException {
    //     List<String> puzzleInput = List.of("234234234234278","818181911112111");
    //     assertEquals("170", day3b.solve(puzzleInput));
    // }

    
    // @Test
    // public void examplePuzzleInput() throws IOException {
    //     List<String> puzzleInput = readPuzzleInputFromFile("day3_example.txt"); 
    //     assertEquals("357", day3b.solve(puzzleInput));
    // }

    @Test
    public void actualPuzzleInput() throws IOException {
        List<String> puzzleInput = readPuzzleInputFromFile("day3.txt"); 
        assertEquals("17087", day3b.solve(puzzleInput));
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
