public class Solution {
    // You need to treat n as an unsigned value
    public int reverseBits(int n) {
        int reversed = 0;

        for (int i = 0; i < 32; i++) {
            reversed <<= 1; // Shift left to make room
            reversed |= (n & 1); // Append the LSB of n
            n >>>= 1; // Logical (unsigned) shift right
        }

        return reversed;
    }
}