class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Tc O(M+N)
        // ScO(M+N)
        int N = nums1.length;
        int M = nums2.length;
        int a = 0;
        int b = 0;
        int[] res = new int[N+M];
        int index = 0;

        while(a < N && b < M) {
            if(nums1[a] < nums2[b]) {
                res[index++] = nums1[a];
                a++;
            } else {
                res[index++] = nums2[b];
                b++;
            }
        }

        while(a < N) {
            res[index++] = nums1[a];
            a++;
        }

        while(b < M) {
            res[index++] = nums2[b];
            b++;
        }
        System.out.println(Arrays.toString(res));
        if(res.length % 2 != 0) {
            return (double) res[(res.length-1) / 2];
        } 

        return (res[(res.length - 1) / 2] + res[((res.length - 1) / 2) + 1]) / 2.0;

    }
}