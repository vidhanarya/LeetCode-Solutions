class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        if (n < 4) return 0;

        int numTuples = 0;
        Map<Integer, Integer> distinctProduct = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int product = nums[i] * nums[j];
                distinctProduct.put(product, distinctProduct.getOrDefault(product, 0) + 1);
                numTuples += distinctProduct.get(product) - 1;
            }
        }

        return 8 * numTuples;
    }
}