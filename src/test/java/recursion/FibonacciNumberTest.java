package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciNumberTest {

    FibonacciNumber fibCalculator = new FibonacciNumber();

    @Test
    void testFibonacciOf0() {
        assertEquals(0, fibCalculator.fib(0));
    }

    @Test
    void testFibonacciOf1() {
        assertEquals(1, fibCalculator.fib(1));
    }

    @Test
    void testFibonacciOf2() {
        assertEquals(1, fibCalculator.fib(2));
    }

    @Test
    void testFibonacciOf3() {
        assertEquals(2, fibCalculator.fib(3));
    }

    @Test
    void testFibonacciOf4() {
        assertEquals(3, fibCalculator.fib(4));
    }

    @Test
    void testFibonacciOf10() {
        assertEquals(55, fibCalculator.fib(10));
    }

    @Test
    void testFibonacciOf30() {
        assertEquals(832040, fibCalculator.fib(30));
    }
}
