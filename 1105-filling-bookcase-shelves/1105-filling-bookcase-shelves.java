class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        dp[1] = books[0][1];

        for (int i = 1; i < books.length; i++) {
            int maxHeight = books[i][1];
            int remainingWidth = shelfWidth - books[i][0];
            dp[i+1] = maxHeight + dp[i];

            for (int j = i-1; j >= 0; j--) {
                if (remainingWidth - books[j][0] < 0) break;

                int previousBookHeight = books[j][1];
                maxHeight = Math.max(maxHeight, previousBookHeight);
                remainingWidth -= books[j][0];

                dp[i+1] = Math.min(dp[i+1], maxHeight + dp[j]);
            }
        }

        return dp[books.length];
    }
}