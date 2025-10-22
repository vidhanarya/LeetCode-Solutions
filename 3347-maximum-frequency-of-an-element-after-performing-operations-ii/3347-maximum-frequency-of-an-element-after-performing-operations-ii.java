class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        Map<Integer, Integer> freqMap = new HashMap<>();
        Set<Integer> checks = new HashSet<>();
        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
            checks.add(n);
            checks.add(n-k);
        }

        int len = nums.length;
        int result = 0;
        for (int i : checks) {
            int l = binarySearchLeft(nums, i-k, 0, len-1);
            int r = binarySearchRight(nums, i+k, 0, len-1);
            int f = freqMap.getOrDefault(i, 0);

            result = Math.max(result, f + Math.min(numOperations, r-l+1-f));
        }

        return result;
    }

    public int binarySearchLeft(int[] nums, int v, int l, int r) {
        while (l < r) {
            int m = l + (r-l)/2;

            if (nums[m] < v) l = m+1;
            else r = m;
        }
        return r;
    }

    public int binarySearchRight(int[] nums, int v, int l, int r) {
        while (l < r) {
            int m = r - (r-l)/2;

            if (nums[m] > v) r = m-1;
            else l = m;
        }
        return l;
    }
}