class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length + 1][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int h = 0; h < 2; h++) {
                dp[i][h] = dp[i+1][h];
                if (h == 0) dp[i][h] = Math.max(dp[i][h], -prices[i] + dp[i+1][1]);
                else dp[i][h] = Math.max(dp[i][h], prices[i] - fee + dp[i+1][0]);
            }
        }

        return dp[0][0];
    }
}