class Solution {
    public int uniquePaths(int m, int n) {
        if (n > m) return uniquePaths(n, m);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < m-1; i++) {
            for (int j = n - 2; j >=0 ; j--) {
                dp[j] += dp[j+1];
            }
        }

        return dp[0];
    }
}