class Solution {
    public long continuousSubarrays(int[] nums) {
        long result = 0;
        int left = 0, right = 0;

        int min = nums[0], max = nums[right];
        for (right = 0; right < nums.length; right++) {
            min = Math.min(min, nums[right]);
            max = Math.max(max, nums[right]);

            if (max - min <= 2) continue;

            result += ((long) (right - left) * (right - left + 1)) / 2;

            left = right;
            min = nums[left];
            max = nums[left];

            while (left > 0 && Math.max(max, nums[left - 1]) - Math.min(min, nums[left - 1]) <= 2) {
                left--;
                min = Math.min(min, nums[left]);
                max = Math.max(max, nums[left]);
            }

            result -= ((long) (right - left) * (right - left + 1)) / 2;
        }

        result += ((long) (right - left) * (right - left + 1)) / 2;
        return result;
    }
}