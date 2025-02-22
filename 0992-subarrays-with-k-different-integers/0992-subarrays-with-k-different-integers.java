class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer, Deque<Integer>> indexes = new HashMap<>();

        int result = 0, left = 0;
        int start = -1;
        for (int right = 0; right < nums.length; right++) {
            indexes.computeIfAbsent(nums[right], _ -> new ArrayDeque<>()).addLast(right);
            if (start == -1 && indexes.size() == k) {
                start = right;
            }

            while (indexes.size() > k) {
                result += right - start;
                Deque<Integer> leftDeque = indexes.get(nums[left]);
                leftDeque.removeFirst();

                if (leftDeque.isEmpty()) {
                    start = right;
                    indexes.remove(nums[left]);
                } else {
                    start = Math.max(start, leftDeque.getFirst());
                }
                left++;
            }
        }

        while (indexes.size() == k) {
            result += nums.length - start;
            Deque<Integer> leftDeque = indexes.get(nums[left]);
            leftDeque.removeFirst();

            if (leftDeque.isEmpty()) break;
            else start = Math.max(start, leftDeque.getFirst());
            left++;
        }

        return result;
    }
}

