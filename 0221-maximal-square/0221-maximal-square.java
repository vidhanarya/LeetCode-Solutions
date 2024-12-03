class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] =  matrix[i][j] - '0';
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                if (dp[i][j] == 0) continue;

                int currLen = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j]));
                dp[i][j] = currLen;
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen * maxLen;
    }
}