class Solution {
    public int[] rearrangeArray(int[] nums) {
        int index = 0;
        int[] result = new int[nums.length];

        int posIndex = 0;
        int negIndex = 1;
        
        for (int num : nums) {
            if (num < 0) {
                result[negIndex] = num;
                negIndex +=2;
            }
        }

        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex +=2;
            }
        }
        

        return result;
    }
}