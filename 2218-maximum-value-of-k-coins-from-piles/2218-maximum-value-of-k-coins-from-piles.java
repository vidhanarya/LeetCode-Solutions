

class Solution {
    int[][] dp;

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        dp = new int[piles.size()][k+1];
        for (int i = 0; i < piles.size(); i++) Arrays.fill(dp[i], -1);

        return dp(piles, 0, k);
    }

    public int dp(List<List<Integer>> piles, int i, int k) {
        if (k == 0 || i >= piles.size()) return 0;
        if (dp[i][k] != -1) return dp[i][k];

        int ans = dp(piles, i + 1, k);
        int sum = 0;
        for (int j = 1; j <= Math.min(k, piles.get(i).size()); j++) {
            sum += piles.get(i).get(j-1);
            ans = Math.max(ans, sum + dp(piles, i + 1, k-j));
        }

        dp[i][k] = ans;
        return ans;
    }
}