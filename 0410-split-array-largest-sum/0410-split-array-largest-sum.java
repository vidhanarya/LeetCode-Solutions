class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0, right = 1000000001;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(nums, k, mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public boolean check(int[] nums, int k, int sum) {
        int currSum = 0;
        int groups = 0;
        for (int n: nums) {
            if (n > sum) return false;
            if (currSum + n > sum) {
                groups++;
                currSum = 0;
            }

            currSum += n;
        }

        if (currSum > 0) groups++;
        return (groups <= k);
    }
}