class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> goodPairCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i] - i;
            goodPairCount.put(value, goodPairCount.getOrDefault(value, 0) + 1);
        }

        long totalGoodPairs = 0;
        for (int count : goodPairCount.values()) {
            totalGoodPairs += getCombinations(count);
        }

        long totalPairs = getCombinations(nums.length);
        return totalPairs - totalGoodPairs;
    }

    public long getCombinations(int n) {
        if (n % 2 == 0) return (n / 2) * (n - 1);
        return n * ((n - 1) / 2);
    }
}
