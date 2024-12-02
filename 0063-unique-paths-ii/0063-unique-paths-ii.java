class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m + 1];
        for (int i = m-1; i >= 0; i--) {
            if (obstacleGrid[n-1][i] == 1) break;
            dp[i] = 1;
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];
    }
}