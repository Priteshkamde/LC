class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        while (n != 1) {
            int sum = 0;  // sum reset
            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10; 
            }

            // found
            if (sum == 1) {
                return true;
            }

            // detect cycle
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        
        return true;
    }
}
