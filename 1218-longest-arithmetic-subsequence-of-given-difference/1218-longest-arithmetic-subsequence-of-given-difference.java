class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();

        int maxLen = 0;
        for (int n: arr) {
            int currLen = 1 + dp.getOrDefault(n - difference, 0);
            if (dp.getOrDefault(n, 0) >= currLen) continue;

            maxLen = Math.max(currLen, maxLen);
            dp.put(n, 1 + dp.getOrDefault(n - difference, 0));
        }

        return maxLen;
    }
}