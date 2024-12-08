class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;

        int curr = 0;
        while (curr < nums.length) {
            if (nums[curr] == 0) return false;
            if (curr + nums[curr] >= nums.length - 1) return true;

            int next = curr;
            int maxReach = curr + nums[curr];
            for (int i = curr + 1; i <= curr + nums[curr]; i++) {
                if (i + nums[i] >= maxReach) {
                    next = i;
                    maxReach = i + nums[i];
                }
            }
            curr = next;
        }

        return true;
    }
}