class Solution {
    public int uniquePaths(int m, int n) {
        // We only need a 1D array to save space
        int[] dp = new int[n];
        
        // Initialize the first row: only 1 way to reach any cell in the first row (all Rights)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Fill the DP table row by row
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The new dp[j] = current dp[j] (from above) + dp[j-1] (from left)
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
