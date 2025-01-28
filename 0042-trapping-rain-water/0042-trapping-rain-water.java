class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int maxWater = 0;

        while (left <= right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft <= maxRight) {
                maxWater += maxLeft - height[left++];
            } else {
                maxWater += maxRight - height[right--];
            }
        }

        return maxWater;
    }
}