class Solution {
    int[][][] memo;
    
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[strs.length][m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dp(strs, 0, m, n);
    }

    public int dp(String[] strs, int i, int m, int n) {
        if (i >= strs.length) return 0;
        if (memo[i][m][n] != -1) return memo[i][m][n];

        int[] count = countZeroAndOne(strs[i]);
        int ans = dp(strs, i+1, m, n);
        if (count[0] <= m && count[1] <= n) {
            ans = Math.max(ans, 1 + dp(strs, i+1, m-count[0], n-count[1]));
        }

        memo[i][m][n] = ans;
        return ans;
    }

    public int[] countZeroAndOne(String s) {
        int[] result = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') result[0]++;
            else result[1]++;
        }
        return result;
    }
}