class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        int N = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        if(N <= 3) return res;

        Arrays.sort(nums);
        for(int i = 0 ; i < N ; i++) {
            for(int j= i+1 ; j < N; j++) {

                int a = nums[i]; 
                int b = nums[j];
                long target2 = (long)target - (long)a - (long)b;

                // perform 2 sum
                int front = j+1; int rear = N-1;
                while(front<rear) {
                    long twoSum = (long) nums[front] + (long) nums[rear];
                    if (twoSum < target2) front++;
                    else if (twoSum > target2) rear--;
                    // found
                    else {
                        List<Integer> quad = new ArrayList();
                        quad.add(a); quad.add(b);
                        quad.add(nums[front]);
                        quad.add(nums[rear]);
                        res.add(quad);

                        while(front < rear && nums[front] == quad.get(2)) front++;
                        while(front < rear && nums[rear] == quad.get(3)) rear--;
                    }
                }

            while(j+1 < N && nums[j]==nums[j+1]) j++;
            } 
        while(i+1 < N && nums[i]==nums[i+1]) i++;
        } 


        return res;

    }
}