class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int h = 0; h < 2; h++) {
                if (h == 0) dp[i][h] = Math.max(dp[i+1][h], dp[i+1][1] - prices[i]);
                else dp[i][h] = Math.max(dp[i+1][h], dp[i+2][0] + prices[i]);
            }
        }

        return dp[0][0];
    }
}