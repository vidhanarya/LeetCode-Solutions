class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0; i <= coins.length; i++) dp[i][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int a = 1; a <= amount; a++) {
                for (int c = 0; c <= a/coins[i-1]; c++) {
                    dp[i][a] += dp[i-1][a - coins[i-1] * c];
                }
            }
        }

        return dp[coins.length][amount];
    }
}