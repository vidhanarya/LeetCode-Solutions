class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] = 2*nums[i];
                nums[i+1] = 0;
            }
        }

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (left < nums.length && nums[left] != 0) {
                left++;
            }

            if (right < left || nums[right] == 0) {
                continue;
            }
            
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
        }

        return nums;
    }
}