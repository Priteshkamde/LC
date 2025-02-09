class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int N = numbers.length;
        int low = 0;
        int high = N-1;
        int sum = 0;
        while(low < high){
            sum = numbers[low] + numbers[high];
            if(sum == target)
                return new int[]{low+1, high+1};
            if(sum > target)
                high-=1;
            else 
                low+=1;
        }

    return new int[]{};   
    }
}