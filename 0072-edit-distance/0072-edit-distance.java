class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] cost = new int[m + 1][n + 1];

        // base case empty string to another
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int j = 1; j <= n; j++)
            cost[0][j] = j;
        
        // dp
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    cost[i + 1][j + 1] = cost[i][j]; // if same character- no cost involved
                } else {
                    cost[i + 1][j + 1] = 1 + Math.min(
                        cost[i][j], 
                        Math.min(cost[i][j + 1], cost[i + 1][j]));
                }
            }
        }
        return cost[m][n];
    }
}
