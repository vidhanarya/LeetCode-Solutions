class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = n-1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i+1;
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, heights[i]*(right[i] - left[i]));
        }

        return maxArea;
    }
}