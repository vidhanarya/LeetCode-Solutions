class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] suffix = new int[n];
        suffix[n-1] = values[n-1] - (n-1);
        for (int i = values.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(values[i] - i, suffix[i+1]);
        }

        int result = 0;
        for (int i = 0; i < n-1; i++) {
            result = Math.max(result, values[i] + i + suffix[i+1]);
        }

        return result;
    }
}

// P1 - P2
// (X + x) - (Y + y)