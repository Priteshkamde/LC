class Solution {
    public int threeSumSmaller(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int N = nums.length;

        int count = 0;

        for (int i = 0; i < N - 2; i++) {

            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
