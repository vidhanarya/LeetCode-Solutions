class Solution {
    public boolean divideArray(int[] nums) {
        boolean[] even = new boolean[500+1];
        Arrays.fill(even, true);

        for (int n : nums) {
            even[n] = !even[n];
        }

        for (int i = 0; i < even.length; i++) {
            if (!even[i]) {
                return false;
            }
        }

        return true;
    }
}