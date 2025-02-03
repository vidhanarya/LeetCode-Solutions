class Solution {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int[] count = new int[1 << 16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count[nums[i] & nums[j]]++;
            }
        }

        int triplets = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < count.length; j++) {
                if ((nums[i] & j) == 0) triplets += count[j];
                else j += (nums[i] & j) - 1;
            }
        }

        return triplets;
    }
}