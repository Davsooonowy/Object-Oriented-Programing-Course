package agh.ics.oop.model;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class OptionsParserTest {
    @Test
    void parse() {
        String[] args = {"f", "b", "r", "l"};
        MoveDirection[] directions = OptionsParser.parse(args);
        MoveDirection[] expectedDirections = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        assertArrayEquals(expectedDirections, directions);
    }
}
