class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int low = 0;
        int high = numbers.length-1;

        while(low < high) {
            int t = numbers[low] + numbers[high];
            if(t == target)
                return new int[]{low+1, high+1};
            else if (t < target)
                low++;
            else 
                high--;
        }

        return new int[]{};
    }
}