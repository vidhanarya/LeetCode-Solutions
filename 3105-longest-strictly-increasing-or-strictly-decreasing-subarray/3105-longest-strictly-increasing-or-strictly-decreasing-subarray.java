class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int longestIncreasing = 0, longestDecreasing = 0, left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] <= nums[right-1]) left = right;
            longestIncreasing = Math.max(longestIncreasing, right - left + 1);
        }

        left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] >= nums[right-1]) left = right;
            longestDecreasing = Math.max(longestDecreasing, right - left + 1);
        }

        return Math.max(longestDecreasing, longestIncreasing);
    }
}