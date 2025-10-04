class Solution {
    public void nextPermutation(int[] nums) {
        int r = nums.length - 2;
        while (r >= 0 && nums[r] >= nums[r+1]) {
            r--;
        }

        reverse(nums, r+1, nums.length - 1);
        if (r >= 0) {
            int j = r+1;
            while (nums[j] <= nums[r]) j++;
            swap(nums, r, j);
        }
        return;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}