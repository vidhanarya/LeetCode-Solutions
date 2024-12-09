class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        dp[n - 1] = 0;
        
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = n;
            for (int j = i+1; j <= Math.min(n-1, i+nums[i]); j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }

        return dp[0];
    }
}