class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, duplicateCount = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                duplicateCount = 0;
                swap(nums, ++i, j);
            }
            else if (nums[j] == nums[i] && duplicateCount == 0) {
                duplicateCount++;
                swap(nums, ++i, j);
            }
        }

        return i+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}