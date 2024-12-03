class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        List<Integer>[] dp = new List[nums.length];
        int resultIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % dp[j].get(dp[j].size() - 1) != 0) continue;
                if (dp[j].size() < dp[i].size()) continue;

                dp[i].clear();
                dp[i].addAll(dp[j]);
            }
            dp[i].add(nums[i]);

            if (dp[i].size() > dp[resultIdx].size()) resultIdx = i;
        }

        return dp[resultIdx];
    }
}