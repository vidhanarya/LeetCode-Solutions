class Solution {
    public int minMoves(int[] nums) {
        int moves = 0, min = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
        }

        for (int n : nums) {
            moves += n - min;
        }
        return moves;
    }
}