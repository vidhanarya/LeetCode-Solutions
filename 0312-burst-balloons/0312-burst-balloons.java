class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length+2;
        int[] newNums = new int[n];
        newNums[0] = 1;
        newNums[n-1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n-2);

        int[][] memo = new int[n][n];
        return dp(newNums, memo, 1, n-2);
    }

    public int dp(int[] nums, int[][] memo, int left, int right) {
        if (left > right) return 0;
        if (memo[left][right] > 0) return memo[left][right];

        int result = 0;
        for (int i = left; i <= right; i++) {
            int currCoins = nums[left-1]*nums[i]*nums[right+1];
            currCoins += dp(nums, memo, left, i-1);
            currCoins += dp(nums, memo, i+1, right);

            result = Math.max(result, currCoins);
        }

        memo[left][right] = result;
        return result;
    }
}