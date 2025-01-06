package Amazon;

class Solution {
    static String matrixChainOrder(int p[]) {
        int n = p.length;
        int[][] dp = new int[n][n];
        int[][] s = new int[n][n]; // To store the split points

        // Fill the dp table with 0s for single matrix
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // Fill the DP table for lengths of chains 2 to n
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible split
                for (int k = i; k < j; k++) {
                    int q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        // Recursively construct the optimal multiplication order
        return constructOrder(s, 1, n - 1);
    }

    // Helper function to construct the string using the split points table
    private static String constructOrder(int[][] s, int i, int j) {
        if (i == j) {
            return String.valueOf((char) ('A' + i - 1));
        } else {
            String left = constructOrder(s, i, s[i][j]);
            String right = constructOrder(s, s[i][j] + 1, j);
            return "(" + left + right + ")";
        }
    }
}