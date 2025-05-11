package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfThreeTest {

    PowerOfThree obj = new PowerOfThree();

    @Test
    void testPowerOfThreeWith27() {
        assertTrue(obj.isPowerOfThree(27)); // 3^3
    }

    @Test
    void testPowerOfThreeWith0() {
        assertFalse(obj.isPowerOfThree(0)); // not power of 3
    }

    @Test
    void testPowerOfThreeWith9() {
        assertTrue(obj.isPowerOfThree(9)); // 3^2
    }

    @Test
    void testPowerOfThreeWith45() {
        assertFalse(obj.isPowerOfThree(45)); // not power of 3
    }

    @Test
    void testPowerOfThreeWith1() {
        assertTrue(obj.isPowerOfThree(1)); // 3^0
    }

    @Test
    void testNegativeNumber() {
        assertFalse(obj.isPowerOfThree(-27)); // negative cannot be power of 3
    }

    @Test
    void testLargeNonPower() {
        assertFalse(obj.isPowerOfThree(2147483647)); // Max int, not power of 3
    }

    @Test
    void testLargestPowerOfThreeInInt() {
        assertTrue(obj.isPowerOfThree(1162261467)); // 3^19, max power of 3 in 32-bit int
    }
}
