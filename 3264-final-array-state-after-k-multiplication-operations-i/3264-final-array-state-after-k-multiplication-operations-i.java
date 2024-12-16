class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> {
            if (nums[i] == nums[j]) return i - j;
            return nums[i] - nums[j];
        });
        for (int i = 0; i < nums.length; i++) pq.offer(i);

        while (k-- > 0) {
            int idx = pq.poll();
            nums[idx] *= multiplier;
            pq.offer(idx);
        }

        return nums;
    }
}