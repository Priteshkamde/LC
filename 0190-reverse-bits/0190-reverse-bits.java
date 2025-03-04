public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // Shift left to make space
            // extracted bit is (n&1)
            result |= (n & 1); // add it to result
            n >>= 1; // Shift n right in the given n to process next bit
        }
        return result;
    }
}