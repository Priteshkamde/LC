class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];

        // formula is [num / 2] + last bit check 
        for (int i = 1; i <= n; i++)
            result[i] = result[i >> 1] + (i & 1);

        return result;
    }
}