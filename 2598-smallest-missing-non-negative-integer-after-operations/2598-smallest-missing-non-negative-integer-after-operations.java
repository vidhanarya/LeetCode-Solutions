class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            int r = n % value;
            if (r < 0) {
                r += value;
            }
            freq.put(r, freq.getOrDefault(r, 0) + 1);
        }

        int result = 0;
        while (!freq.isEmpty()) {
            int r = result % value;
            int f = freq.getOrDefault(r, 0);
            if (f == 0) {
                return result;
            }

            freq.put(r, f - 1);
            result++;
        }

        return result;
    }
}