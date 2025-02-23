class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        long[] right = new long[n];

        Stack<Integer> monotonic = new Stack<>();
        left[0] = maxHeights.get(0);
        monotonic.push(0);
        for (int i = 1; i < n; i++) {
            while (!monotonic.empty() && maxHeights.get(i) < maxHeights.get(monotonic.peek())) {
                monotonic.pop();
            }

            if (monotonic.empty()) {
                left[i] = maxHeights.get(i) * (i + 1);
            } else {
                left[i] = (long) left[monotonic.peek()] + maxHeights.get(i) * (i - monotonic.peek());
            }
            monotonic.push(i);
        }

        monotonic = new Stack<>();
        right[n-1] = maxHeights.get(n-1);
        monotonic.push(n-1);
        for (int i = n-2; i >= 0; i--) {
            while (!monotonic.empty() && maxHeights.get(i) < maxHeights.get(monotonic.peek())) {
                monotonic.pop();
            }

            if (monotonic.empty()) {
                right[i] = maxHeights.get(i) * (n - i);
            } else {
                right[i] = (long) right[monotonic.peek()] + maxHeights.get(i) * (monotonic.peek() - i);
            }
            monotonic.push(i);
        }

        long maxHeightSum = 0;
        for (int i = 0; i < n; i++) {
            maxHeightSum = Math.max(maxHeightSum, left[i] + right[i] - maxHeights.get(i));
        }

        return maxHeightSum;
    }
}