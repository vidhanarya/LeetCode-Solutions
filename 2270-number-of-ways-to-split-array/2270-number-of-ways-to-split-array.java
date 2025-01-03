class Solution {
    public int waysToSplitArray(int[] nums) {
        long left = 0, right = 0;
        for (int n: nums) right += n;

        int splits = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            right -= nums[i];

            if (left >= right) splits++;
        }

        return splits;
    }
}