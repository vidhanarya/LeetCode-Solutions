class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        dp[m-1] = grid[n-1][m-1];
        for (int i = m-2; i >= 0; i--) {
            dp[i] = dp[i+1] + grid[n-1][i];
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (j == m-1) dp[j] += grid[i][j];
                else dp[j] = Math.min(grid[i][j] + dp[j], grid[i][j] + dp[j+1]);
            }
        }

        return dp[0];
    }
}