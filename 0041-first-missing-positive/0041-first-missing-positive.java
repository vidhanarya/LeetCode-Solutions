class Solution {
    public int firstMissingPositive(int[] nums) {
        int positiveIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                swap(nums, i, positiveIdx);
                positiveIdx++;
            }
        }

        for (int i = positiveIdx; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length-positiveIdx && nums[nums[i]-1+positiveIdx] != nums[i]) {
                swap(nums, i, positiveIdx-1+nums[i]);
            }
        }

        for (int i = positiveIdx; i < nums.length; i++) {
            if (nums[i] != i-positiveIdx+1) return i-positiveIdx+1;
        }

        return nums.length-positiveIdx+1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}