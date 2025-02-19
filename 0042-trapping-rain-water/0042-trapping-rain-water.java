class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int heightLeft = height[left], heightRight = height[right];
        int water = 0;
        while (left <= right) {
            heightLeft = Math.max(heightLeft, height[left]);
            heightRight = Math.max(heightRight, height[right]);

            if (heightLeft <= heightRight) water += heightLeft - height[left++];
            else water += heightRight - height[right--];
        }

        return water;
    }
}