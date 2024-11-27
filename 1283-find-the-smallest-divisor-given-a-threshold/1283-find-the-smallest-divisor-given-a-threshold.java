class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 1000000;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(nums, threshold, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public boolean check(int[] nums, int threshold, int divisor) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += (int) Math.ceil(nums[i] / (double) divisor);
        }
        return total <= threshold;
    }
}