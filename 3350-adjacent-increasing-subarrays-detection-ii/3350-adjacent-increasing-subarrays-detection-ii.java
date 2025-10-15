class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int result = 0;
        int prev = -1;
        int curr = 1;

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i-1)) {
                curr++;
            } else {
                prev = curr;
                curr = 1;
            }
            result = Math.max(curr/2 , Math.max(result, Math.min(prev, curr)));
        }

        return result;
    }
}