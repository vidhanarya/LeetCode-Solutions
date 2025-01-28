class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int MOD = 1_000_000_007;
        long numGoodSubarrays = 0;
        int left = nums.length-1, right = nums.length-1;
        while (left >= 0) {
            if (numGoodSubarrays == 0 && nums[left] == 1) {
                numGoodSubarrays = 1;
                right = left;
            } else if (nums[left] == 1) {
                int numZeros = Math.max(0, right - left - 1);
                numGoodSubarrays = (((numZeros+1) % MOD) * (numGoodSubarrays % MOD)) % MOD;
                right = left;
            }
            
            left--;
        }

        return (int) numGoodSubarrays % MOD;
    }
}
