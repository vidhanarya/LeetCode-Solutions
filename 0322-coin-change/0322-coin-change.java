class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int c: coins) {
                if (a < c) continue;
                if (a == c) dp[a] = 1;
                else dp[a] = Math.min(dp[a], 1 + dp[a-c]);
            }
        }

        return (dp[amount] == 10001) ? -1 : dp[amount];
    }
}