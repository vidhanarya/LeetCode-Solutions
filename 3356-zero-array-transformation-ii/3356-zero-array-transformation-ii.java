class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(nums, queries, mid)) right = mid;
            else left = mid+1;
        }

        return (left == queries.length) ? -1 : left+1;
    }

    private boolean check(int[] nums, int[][] queries, int k) {
        int[] prefix = new int[nums.length];
        for (int i = 0; i <= k; i++) {
            prefix[queries[i][0]] -= queries[i][2];
            if (queries[i][1]+1 < nums.length) prefix[queries[i][1]+1] += queries[i][2];
        }

        for (int i = 0; i < prefix.length; i++) {
            if (i > 0) prefix[i] += prefix[i-1];
            if (prefix[i] + nums[i] > 0) return false;
        }

        return true;
    }
}