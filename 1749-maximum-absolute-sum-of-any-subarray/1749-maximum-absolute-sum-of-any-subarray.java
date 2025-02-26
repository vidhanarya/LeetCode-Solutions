class Solution {
    public int maxAbsoluteSum(int[] nums) {
        return Math.max(maxSum(nums, false), maxSum(nums, true));
    }

    private int maxSum(int[] nums, boolean reverse) {
        int left = 0, maxSum = 0, currSum = 0;
        for (int right = 0; right < nums.length; right++) {
            currSum += (reverse) ? -nums[right] : nums[right];
            while (currSum < 0) {
                currSum -= (reverse) ? -nums[left] : nums[left];
                left++;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }
}