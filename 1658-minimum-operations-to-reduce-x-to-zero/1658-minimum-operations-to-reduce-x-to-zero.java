class Solution {
    public int minOperations(int[] nums, int x) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int totalSum = prefixSum[nums.length-1];
        if (x == totalSum) return nums.length;

        int target = totalSum - x;
        int maxWindow = -1;
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);

        for (int right = 0; right < nums.length; right++) {
            int b = prefixSum[right];
            int a = b - target;
            if (!indexMap.containsKey(b)) indexMap.put(b, right);
            if (!indexMap.containsKey(a)) continue;

            int left = indexMap.get(a);
            maxWindow = Math.max(maxWindow, right - left);
        }

        if (maxWindow == -1) return -1;
        return nums.length - maxWindow;
    }
}
