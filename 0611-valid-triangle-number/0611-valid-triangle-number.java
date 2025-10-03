

import static java.util.Collections.binarySearch;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        while (start <= end && nums[start] == 0) {
            start++;
        }

        int k = end;
        int count = 0;
        while (k >= start) {
            int i = start, j = k-1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
            k--;
        }

        return count;
    }
}