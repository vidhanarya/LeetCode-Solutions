class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int r = 0; r <= n; r++) {
            dp[r][0] = r;
        }
        for (int c = 0; c <= m; c++) {
            dp[0][c] = c;
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (str1.charAt(r-1) == str2.charAt(c-1)) {
                    dp[r][c] = dp[r-1][c-1] + 1;
                } else {
                    dp[r][c] = Math.min(dp[r-1][c], dp[r][c-1]) + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int row = n, col = m;
        while (row > 0 && col > 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                sb.append(str1.charAt(row-- - 1));
                col--;
            } else if (dp[row - 1][col] < dp[row][col - 1]) sb.append(str1.charAt(row-- - 1));
            else sb.append(str2.charAt(col-- - 1));
        }

        while (row > 0) sb.append(str1.charAt(row-- - 1));
        while (col > 0) sb.append(str2.charAt(col-- - 1));

        return sb.reverse().toString();
    }
}