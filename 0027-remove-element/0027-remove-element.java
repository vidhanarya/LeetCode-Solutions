class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[r] == val) r--;
            else if (nums[l] == val) swap(nums, l++, r--);
            else l++;
        }

        return l;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}