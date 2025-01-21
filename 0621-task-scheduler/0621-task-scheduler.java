class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] countFreq = new int[26];

        for(int t : tasks) {
            countFreq[ t - 'A']++;
        }

        Arrays.sort(countFreq);
        int maxFreq = countFreq[25];

        int maxCount = 0;

        for(int i : countFreq){
            if(i == maxFreq)
                maxCount++;
        }

        int result = (maxFreq-1) * (n+1) + maxCount;

        return Math.max(result, tasks.length);

    }
}