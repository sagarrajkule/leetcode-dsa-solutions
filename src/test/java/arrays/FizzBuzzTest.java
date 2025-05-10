package arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fb = new FizzBuzz();

    @Test
    void testFizzBuzz_3() {
        List<String> expected = List.of("1", "2", "Fizz");
        assertEquals(expected, fb.fizzBuzz(3), "Test failed for n = 3");
    }

    @Test
    void testFizzBuzz_5() {
        List<String> expected = List.of("1", "2", "Fizz", "4", "Buzz");
        assertEquals(expected, fb.fizzBuzz(5), "Test failed for n = 5");
    }

    @Test
    void testFizzBuzz_15() {
        List<String> expected = List.of(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
                "11", "Fizz", "13", "14", "FizzBuzz"
        );
        assertEquals(expected, fb.fizzBuzz(15), "Test failed for n = 15");
    }
}
