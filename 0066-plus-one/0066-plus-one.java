class Solution {
    public int[] plusOne(int[] digits) {
        int N = digits.length;

        for (int i = N - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        int result[] = new int[N + 1];
        result[0] = 1;

        return result;
    }
}