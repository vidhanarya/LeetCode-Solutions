class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if ((mid == 0 && nums[mid] != nums[mid + 1]) ||
                    (mid == nums.length - 1 && nums[mid] != nums[mid - 1]) ||
                    (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }

            if (((right - mid + 1) % 2 == 0 && nums[mid] != nums[mid + 1]) ||
                    ((right - mid + 1) % 2 == 1 && nums[mid] == nums[mid + 1])) {
                left = mid + 1;
            } else {
                right = mid - 1 + (right - mid + 1) % 2;
            }
        }

        return nums[left];
    }
}