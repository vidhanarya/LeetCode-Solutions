class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroCount = 0, left = 0;
        int maxOnes = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;
            while (zeroCount > 1) {
                zeroCount -= 1 - nums[left++];
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
        }

        return maxOnes;
    }
}