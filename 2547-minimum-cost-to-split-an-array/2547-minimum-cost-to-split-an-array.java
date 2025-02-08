class Solution {
    public int minCost(int[] nums, int k) {
        long[] dp = new long[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Long.MAX_VALUE;

            int trimmed = 0;
            int[] freq = new int[nums.length];
            for (int j = i; j > 0; j--) {
                freq[nums[j-1]]++;
                if (freq[nums[j-1]] == 2) trimmed += 2;
                else if (freq[nums[j-1]] > 2) trimmed += 1;

                dp[i] = Math.min(dp[i], dp[j-1] + k + trimmed);
            }
        }

        return (int) dp[nums.length];
    }
}