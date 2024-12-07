class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 1000000000;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(nums, mid, maxOperations)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public boolean check(int[] nums, int limit, int maxOperations) {
        int operations = 0;
        for (int n : nums) {
            operations += Math.ceilDiv(n, limit) - 1;
            if (operations > maxOperations) return false;
        }

        return true;
    }
}