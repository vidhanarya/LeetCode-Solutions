class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int second = cost[cost.length - 1];
        int first = cost[cost.length - 2];

        for (int i = cost.length - 3; i >= 0; i--) {
            int temp = first;
            first = Math.min(first + cost[i], (cost[i] + second));
            second = temp;
        }

        return Math.min(first, second);
    }
}