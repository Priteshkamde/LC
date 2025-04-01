class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int totalTank = 0;
        int currTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int gain = gas[i] - cost[i];
            totalTank += gain;
            currTank += gain;

            if (currTank < 0) {
                // reset
                startIndex = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }
}