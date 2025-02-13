class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            if (n > k) continue;
            minHeap.offer((long) n);
        }

        int count = 0;
        while (minHeap.size() > 1 && minHeap.peek() < k) {
            minHeap.offer(2*minHeap.poll() + minHeap.poll());
            count++;
        }

        if (minHeap.peek() >= k) return count;
        return count+1;
    }
}