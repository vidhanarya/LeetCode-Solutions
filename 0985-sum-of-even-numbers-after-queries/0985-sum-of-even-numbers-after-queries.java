class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] sums = new int[queries.length];

        int evenSum = 0;
        for (int n : nums) {
            if (n % 2 == 0) {
                evenSum += n;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int prevVal = nums[queries[i][1]];
            int newVal = prevVal + queries[i][0];

            if (prevVal % 2 == 0 && newVal % 2 == 0) evenSum += queries[i][0];
            else if (prevVal % 2 == 0 && newVal % 2 != 0) evenSum -= prevVal;
            else if (prevVal % 2 != 0 && newVal % 2 == 0) evenSum += newVal;

            nums[queries[i][1]] = newVal;
            sums[i] = evenSum;
        }

        return sums;
    }
}