class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] monotonic = new int[nums.length];
        Arrays.fill(monotonic, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] > nums[i]) {
                monotonic[stack.pop()] = i;
            }
            stack.push(i);
        }

        int[] competitiveSeq = new int[k];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx == k) break;
            if (monotonic[i] == -1 || nums.length-monotonic[i] < k-idx) {
                competitiveSeq[idx++] = nums[i];
            }
        }
        
        return competitiveSeq;
    }
}