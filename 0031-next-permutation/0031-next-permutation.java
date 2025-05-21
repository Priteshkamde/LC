class Solution {
    public void nextPermutation(int[] nums) {
        
        // find index
        // [i] < i+1
        int index = -1;
        int N = nums.length;
        for(int i = N-2 ; i >= 0 ; i--) {
            if(nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }

        if(index == -1) {
            rev(nums); 
            return ;    
        }

        for(int i = N-1 ; i > index ; i--) {
            if(nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }

        rev(nums, index+1, N-1);
    }

    void rev(int[] nums, int a, int b) {
        int low = a;
        int high = b;
        while(low <= high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }
    }

    void rev(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;

            low++;
            high--;
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}