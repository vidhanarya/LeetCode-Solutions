class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                if (nums[mid] >= nums[0] && target < nums[0]) {
                    left = mid + 1;   
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] <= nums[nums.length - 1] && target > nums[nums.length - 1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}