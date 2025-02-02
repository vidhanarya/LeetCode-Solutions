class Solution {
    public boolean check(int[] nums) {
        int pivot = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1] && pivot == 0) {
                pivot = i;
            } else if (nums[i] < nums[i-1]) {
                return false;
            }
        }

        return (pivot == 0) ? true : nums[0] >= nums[nums.length - 1];
    }
}