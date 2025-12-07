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

public class Day3aTest {

    Day3a day3a;

    @BeforeEach
    public void setup() {
        day3a = new Day3a();
    }

    @Test
    public void bankOnlyHasTwoBatteries() throws IOException {
        List<String> puzzleInput = List.of("45");
        assertEquals("45", day3a.solve(puzzleInput));
    }

    @Test
    public void firstTwoBatteriesInBankAreTheLargest() throws IOException {
        List<String> puzzleInput = List.of("987654321111111");
        assertEquals("98", day3a.solve(puzzleInput));
    }

    @Test
    public void firstBatteryAndLargestBatteryAfterThat() throws IOException {
        List<String> puzzleInput = List.of("811111111111119");
        assertEquals("89", day3a.solve(puzzleInput));
    }

    @Test
    public void lastBatteryAndLargestBatteryBeforeThat() throws IOException {
        List<String> puzzleInput = List.of("234234234234278");
        assertEquals("78", day3a.solve(puzzleInput));
    }

    @Test
    public void firstBatterIsMidStreamAndSecondBatteryIsLargestAfterThat() throws IOException {
        List<String> puzzleInput = List.of("818181911112111");
        assertEquals("92", day3a.solve(puzzleInput));
    }

    @Test
    public void twoBanksAreAddedTogether() throws IOException {
        List<String> puzzleInput = List.of("234234234234278","818181911112111");
        assertEquals("170", day3a.solve(puzzleInput));
    }

    
    // @Test
    // public void examplePuzzleInput() throws IOException {
    //     List<String> puzzleInput = readPuzzleInputFromFile("dayX_example.txt"); 
    //     assertEquals("", day3a.solve(puzzleInput));
    // }

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
