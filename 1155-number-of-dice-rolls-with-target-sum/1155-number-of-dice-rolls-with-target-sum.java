class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n][target+1];
        for (int i = 0; i <= Math.min(k, target); i++) dp[0][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int a = 1; a <= target; a++) {
                for (int j = 1; j <= k; j++) {
                    if (a <= j) continue;

                    dp[i][a] += dp[i-1][a-j];
                    dp[i][a] = (dp[i][a]) % 1000000007;
                }
            }
        }

        return dp[n-1][target];
    }
}