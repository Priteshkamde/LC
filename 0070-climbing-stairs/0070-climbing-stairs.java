class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        // if(n == 1) return 1;
        // if(n == 2) return 2;

        // int[] stairs = new int[n+1];
        // stairs[1] = 1;
        // stairs[2] = 2;

        // for(int i = 3 ; i < n+1 ; i++) {
        //     stairs[i] = stairs[i-1] + stairs[i-2];
        // }

        // return stairs[n];

        if(n <=2) return n;
        if(map.containsKey(n)) return map.get(n);
        
        int val = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, val);

        return val;
    }
}