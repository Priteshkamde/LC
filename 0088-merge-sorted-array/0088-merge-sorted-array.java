class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        if(m == 0 && n ==0)
            return;

        if(m == 0) 
        {
            for(int i = 0; i < n; i++) 
                nums1[i] = nums2[i];
            return ;
        }

        int writeIndex = m+n-1;
        int bptr = n-1;
        int aptr = m-1;

        while (bptr >= 0) {
            if (aptr >= 0 && nums1[aptr] > nums2[bptr]) {
                nums1[writeIndex] = nums1[aptr];
                aptr--;
            } else {
                nums1[writeIndex] = nums2[bptr];
                bptr--;
            }
            writeIndex--;
        }
        
    }
}