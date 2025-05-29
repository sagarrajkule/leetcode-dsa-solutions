class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0, y = 0;
        int xor = 0;

        // Step 1: XOR all numbers to get xor = x ^ y (two unique numbers)
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // Step 2: Find rightmost set bit in xor (where x and y differ)
        int setBit = xor & (~(xor - 1));

        // Step 3: Divide elements into two groups based on the setBit
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & setBit) == 0) {
                x ^= nums[i];  // 1st bucket
            } else {
                y ^= nums[i];  // 2nd bucket
            }
        }

        return new int[]{x, y};
    }
}
