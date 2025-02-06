class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;

        int[] prefixSum = new int[n];
        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + stones[i];
        }

        int[][][] dp = new int[n][n][k+1];
        Arrays.stream(dp).forEach(arr -> Arrays.stream(arr).forEach(a -> Arrays.fill(a, -1)));

        return minCost(prefixSum, dp, 0, n-1, 1, k);
    }

    public int minCost(int[] prefixSum, int[][][] dp, int i, int j, int p, int k) {
        if (i == j && p == 1) return 0;
        if (i == j) return Integer.MAX_VALUE / 10;
        if (dp[i][j][p] != -1) return dp[i][j][p];


        if (p == 1) {
            dp[i][j][p] = prefixSum[j];
            if (i > 0) dp[i][j][p] -= prefixSum[i-1];
            dp[i][j][p] += minCost(prefixSum, dp, i, j, k, k);
        } else {
            int cost = Integer.MAX_VALUE / 10;
            for (int x = i; x < j; x++) {
                cost = Math.min(cost, minCost(prefixSum, dp, i, x, 1, k) + minCost(prefixSum, dp, x+1, j, p-1, k));
            }
            dp[i][j][p] = cost;
        }

        return dp[i][j][p];
    }
}

