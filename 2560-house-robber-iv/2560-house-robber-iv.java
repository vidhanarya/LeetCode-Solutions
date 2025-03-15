class Solution {
    public int minCapability(int[] nums, int k) {
        int min = 1;
        int max = Arrays.stream(nums).max().getAsInt();

        while (min < max) {
            int mid = min + (max - min) / 2;

            int thefts = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] <= mid) {
                    thefts++;
                    i++;
                }
            }

            if (thefts >= k) max = mid;
            else min = mid+1;
        }

        return min;
    }
}
