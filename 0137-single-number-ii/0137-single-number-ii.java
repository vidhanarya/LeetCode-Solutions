class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenTwice = 0;
        for (int n: nums) {
            seenOnce = (seenOnce ^ n) & (~seenTwice);
            seenTwice = (seenTwice ^ n) & (~seenOnce);
        }

        return seenOnce;
    }
}