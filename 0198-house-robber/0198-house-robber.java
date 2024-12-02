class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int rob(int[] nums) {
        return dp(nums, 0);
    }

    public int dp(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (memo.containsKey(i)) return memo.get(i);

        int maxRob = Math.max(nums[i] + dp(nums, i + 2), dp(nums, i + 1));
        memo.put(i, maxRob);
        return maxRob;
    } 
}