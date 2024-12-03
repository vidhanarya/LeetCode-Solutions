class Solution {
    int[][] memo;

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        for (int i = 0; i < nums1.length; i++) Arrays.fill(memo[i], -1);

        return dp(nums1, nums2, 0, 0);
    }

    public int dp(int[] nums1, int[] nums2, int i, int j) {
        if (i >= nums1.length || j >= nums2.length) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int ans = 0;
        if (nums1[i] == nums2[j]) ans = 1 + dp(nums1, nums2, i+1, j+1);
        else ans = Math.max(dp(nums1, nums2, i+1, j), dp(nums1, nums2, i, j+1));

        memo[i][j] = ans;
        return ans;
    }
}