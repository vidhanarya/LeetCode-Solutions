class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int[] minMax = getMinMax(nums);

        int lo = minMax[0] - k;
        int hi = minMax[1] + k;
        if (lo == hi) return nums.length;


        int[] aux = new int[hi - lo + 2];

        for (int n : nums) {
            aux[n-k-lo] += 1;
            aux[n+k+1-lo] -= 1;
        }

        int result = aux[0];
        for (int i = 1; i < aux.length; i++) {
            aux[i] += aux[i-1];
            result = Math.max(result, aux[i]);
        }

        return result;
    }

    public int[] getMinMax(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return new int[]{min, max};
    }
}