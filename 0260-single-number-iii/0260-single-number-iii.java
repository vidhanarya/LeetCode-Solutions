class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0, first = 0, second = 0;
        for (int n: nums) xor = xor^n;
        xor = xor & (-xor);

        for (int n: nums) {
            if ((xor & n) != 0) first = first ^ n;
            else second = second ^ n;
        }

        return new int[]{first, second};
    }
}