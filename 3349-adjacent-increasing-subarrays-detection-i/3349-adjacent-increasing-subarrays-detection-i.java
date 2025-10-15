class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int prev = -1;
        int curr = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i-1)) {
                curr++;
            }
            if (prev >= k && curr >= k || curr >= 2*k) return true;
            if (nums.get(i) <= nums.get(i-1)) {
                prev = curr;
                curr = 1;
            }
            if (prev >= k && curr >= k || curr >= 2*k) return true;
        }

        return false;
    }
}