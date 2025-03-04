class Solution {
    int[] result;
    int index = 0;
    public int[] countBits(int n) {
        result = new int[n+1];
        for(int i = 0; i <= n ; i ++) {
            cal(i);
        }
        return result;
    }

    public void cal(int num) {
        int count = 0;
        for(int i = 0 ; i < 32 ; i++) {
            if((num & 1) == 1)
                count++;
            num = num >> 1;
        }
        result[index++] = count;
    }
}