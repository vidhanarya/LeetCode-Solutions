class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int maxWater = 0;
        for (int r = 0; r < height.length; r++) {
            int lastHeight = 0;
            while (!stack.empty() && height[stack.peek()] <= height[r]) {
                int l = stack.pop();
                int heightDiff = height[l] - lastHeight;

                maxWater += heightDiff * (r-l-1);
                lastHeight = height[l];
            }

            if (!stack.empty()) {
                maxWater += (height[r]-lastHeight) * (r-stack.peek()-1);
            }
            stack.push(r);
        }

        return maxWater;
    }
}