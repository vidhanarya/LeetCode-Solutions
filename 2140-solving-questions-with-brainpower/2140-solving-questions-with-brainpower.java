class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        for (int i = questions.length - 1; i >= 0; i--) {
            int j = i + questions[i][1] + 1;
            dp[i] = Math.max(dp[i + 1], questions[i][0] + dp[Math.min(questions.length, j)]);
        }

        return dp[0];
    }
}