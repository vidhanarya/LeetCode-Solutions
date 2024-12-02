class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) ans = Math.max(ans, dp(nums, i));
        return ans;
    }

    public int dp(int[] nums, int i) {
        if (memo.containsKey(i)) return memo.get(i);

        int ans = 1;
        for (int j = 0; j < i; j++) {
            if (nums[j] >= nums[i]) continue;
            ans = Math.max(ans, dp(nums, j) + 1);
        }
        memo.put(i, ans);
        return ans;
    }
}