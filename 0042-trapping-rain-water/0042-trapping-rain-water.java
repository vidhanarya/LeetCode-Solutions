class Solution {
    public int trap(int[] height) {
        int trappedWater = 0;
        int left = 0, maxLeft = 0;
        int right = height.length - 1, maxRight = 0;
        while (left <= right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            if (maxLeft <= maxRight) {
                trappedWater += maxLeft - height[left];
                left++;
            } else {
                trappedWater += maxRight - height[right];
                right--;
            }
        }

        return trappedWater;
    }
}