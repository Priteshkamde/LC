class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int A = nums1.length;
        int B = nums2.length;
        int total = A+B;
        int[] sol =  new int[total];

        int i = 0;
        int j = 0;
        int index = 0;
        while( i < A && j < B){
            if(nums1[i] < nums2[j]) {
                sol[index++] = nums1[i++];
            } else {
                sol[index++] = nums2[j++];
            }
        }
        
        while(i < A) {
            sol[index++] = nums1[i++];
        }

        while(j < B) {
            sol[index++] = nums2[j++];
        }

        if(total % 2 == 0) {
            return (double) (sol[total/2] + sol[(total/2)-1]) / 2.0;
        }
        
        return (double) sol[total/2];
    }
}