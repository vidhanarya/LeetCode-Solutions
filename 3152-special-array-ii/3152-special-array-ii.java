class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] subArr = new int[nums.length];
        subArr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2) == (nums[i-1] % 2)) subArr[i] = 1;
            else subArr[i] = subArr[i-1] + 1;
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = (queries[i][1] - queries[i][0] == subArr[queries[i][1]] - subArr[queries[i][0]]);
        }

        return result;
    }
}