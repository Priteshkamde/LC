class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int index = 0;
        int nextStart = 0;
        
        for(int i = 0 ; i < nums1.length ; i++) {

            int num = nums1[i];

            for(int j = 0 ; j < nums2.length ; j++) {
                if(nums2[j] == num) {
                    nextStart = j;
                    break;
                }
            }

            int nextGreater = -1;
            for(int k = nextStart+1 ; k < nums2.length ; k++) {
                if(nums2[k] > num) {
                    nextGreater = nums2[k];
                    break;
                }
            }

            result[index] = nextGreater;
            index++;
        }

        return result;
        
    }
}