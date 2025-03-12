class Solution {
    public int maximumCount(int[] nums) {
        int countNegative = binarySearch(nums, 0);
        int countPositive = nums.length - binarySearch(nums, 1);

        return Math.max(countNegative, countPositive);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) right = mid;
            else left = mid+1;
        }

        return left;
    }
}