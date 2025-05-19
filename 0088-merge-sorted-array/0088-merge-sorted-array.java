class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // to get last index of nums1
        int lastIndex = m + n - 1;
        
        int index1 = m - 1;
        int index2 = n - 1;

        
        if(m == 0) 
        {
            for(int i = 0; i < n; i++) nums1[i] = nums2[i];
            return ;
        }
        while(index2 >= 0){
            
            if(index1 >= 0 && nums1[index1] > nums2[index2]) {
                nums1[lastIndex--] = nums1[index1--]; // side by side copy withing nums1 element
            }
            
            else {
                nums1[lastIndex--] = nums2[index2--]; // move to nums1 from nums2
            }
            
        }               
        } 
    }