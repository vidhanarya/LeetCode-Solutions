class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int[][] dp = new int[n][n];

        for (int i = 2; i < n; i++) {
            int l = 0, r = i-1;

            while (l < r) {
                if (arr[l] + arr[r] > arr[i]) {
                    r--;
                } else if (arr[l] + arr[r] < arr[i]) {
                    l++;
                } else {
                    dp[r][i] = dp[l][r] + 1;
                    maxLen = Math.max(maxLen, dp[r][i]);
                    r--;
                    l++;
                }
            }
        }

        return (maxLen > 0) ? maxLen + 2 : 0;
    }
}
