class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int left = nums.length - 1, right = nums.length - 1;

        long count = 0;
        while (left >= 0) {
            int curr = nums[left];

            while (!deque.isEmpty() && curr > nums[deque.getFirst()]) {
                int first = deque.removeFirst();
                int second = (deque.isEmpty()) ? right+1 : deque.getFirst();

                long increments = (long) (curr - nums[first]) * (second - first);
                if (increments <= k) {
                    k -= increments;
                    continue;
                }


                deque.addFirst(first);
                if (right > deque.getLast()) {
                    k += nums[deque.getLast()] - nums[right];
                } else {
                    deque.removeLast();
                }
                right--;
            }

            deque.addFirst(left);
            count += right - left + 1;
            left--;
        }

        return count;
    }
}

// num [6 3 1 2 4 4]
// idx [0 1 2 3 4 5]
//   0 [1 4 5] k = 5 result = 1 + 2 + 3 + 4 + 5