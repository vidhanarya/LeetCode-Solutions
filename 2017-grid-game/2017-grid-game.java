class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;

        long[][] prefix = new long[2][n+1];
        for (int i = 1; i <= n; i++) {
            prefix[0][i] = prefix[0][i-1] + grid[0][i-1];
            prefix[1][i] = prefix[1][i-1] + grid[1][i-1];
        }

        long secondPlayerScore = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            secondPlayerScore = Math.min(secondPlayerScore, Math.max(prefix[1][i-1], prefix[0][n] - prefix[0][i]));
        }

        return secondPlayerScore;
    }
}
