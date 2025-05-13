class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        boolean[] status = new boolean[2001];

        for (int num : arr) {
            status[num] = true;
        }

        int index = 0;
        for(int i = 1; i < status.length ; i++) {
            if(!status[i]) {
                index++;
                if(index == k) {
                    return i;
                }
            }
        }

        return -1;
    }
}