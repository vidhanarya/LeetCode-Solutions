class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        return Math.max(robHelper(nums, 0, n-2), robHelper(nums, 1, n-1));
    }

    public int robHelper(int[] nums, int i, int j) {
        int first = Math.max(nums[j-1], nums[j]);
        int second = nums[j];

        for (int x = j-2; x >= i; x--) {
            int temp = first;
            first = Math.max(first, nums[x] + second);
            second = temp;
        }
        return first;
    }
}