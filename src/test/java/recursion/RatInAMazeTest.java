package recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RatInAMazeTest {

    RatInAMaze solver = new RatInAMaze();

    @Test
    void testMazeWithTwoPaths() {
        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> expected = Arrays.asList("DDRDRR", "DRDDRR");
        List<String> actual = solver.ratInMaze(maze);
        assertEquals(expected, actual);
    }

    @Test
    void testMazeWithNoPath() {
        int[][] maze = {
            {1, 0},
            {1, 0}
        };

        List<String> expected = new ArrayList<>();
        List<String> actual = solver.ratInMaze(maze);
        assertEquals(expected, actual);
    }

    @Test
    void testMazeWithTwoLexicographicalPaths() {
        int[][] maze = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        List<String> expected = Arrays.asList("DDRR", "RRDD");
        List<String> actual = solver.ratInMaze(maze);
        assertEquals(expected, actual);
    }

    @Test
    void testMazeWithBlockedDestination() {
        int[][] maze = {
            {1, 1},
            {1, 0}
        };

        List<String> expected = new ArrayList<>();
        List<String> actual = solver.ratInMaze(maze);
        assertEquals(expected, actual);
    }

    @Test
    void testFullyOpen2x2Maze() {
        int[][] maze = {
            {1, 1},
            {1, 1}
        };

        List<String> expected = Arrays.asList("DR", "RD");
        List<String> actual = solver.ratInMaze(maze);
        assertEquals(expected, actual);
    }
}
