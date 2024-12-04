class Solution {
    int MOD = 1000000009;

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        while (k > 0) {
            minHeap.add(minHeap.remove() + 1);
            k--;
        }

        int ans = 1;
        while (!minHeap.isEmpty()) ans = (ans * minHeap.remove()) % MOD;
        return ans;
    }
}