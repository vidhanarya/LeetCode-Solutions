class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) return maxNumber(nums2, nums1, k);

        int[] monotonic1 = getMonotonic(nums1);
        int[] monotonic2 = getMonotonic(nums2);

        int[] maxSeq = new int[k];
        for (int i = 0; i <= Math.min(k, nums1.length); i++) {
            List<Integer> seq1 = getMaxSequence(nums1, monotonic1, i);
            List<Integer> seq2 = getMaxSequence(nums2, monotonic2, k-i);
            if (seq1.size() + seq2.size() != k) continue;

            int[] currSeq = merge(seq1, seq2);
            maxSeq = compareSeq(maxSeq, currSeq);
        }

        return maxSeq;
    }

    public int[] compareSeq(int[] seq1, int[] seq2) {
        for (int i = 0; i < seq1.length; i++) {
            if (seq1[i] < seq2[i]) {
                return seq2;
            } else if (seq2[i] < seq1[i]) {
                return seq1;
            }
        }

        return seq1;
    }

    public int[] merge(List<Integer> nums1, List<Integer> nums2) {
        int first = 0, second = 0, mergeIdx = 0;
        int[] mergedSeq = new int[nums1.size() + nums2.size()];

        while (mergeIdx < nums1.size() + nums2.size()) {
            if ((greater(nums1, nums2, first, second))) {
                mergedSeq[mergeIdx++] = nums1.get(first++);
            } else {
                mergedSeq[mergeIdx++] = nums2.get(second++);
            }
        }

        return mergedSeq;
    }

    public boolean greater(List<Integer> nums1, List<Integer> nums2, int f, int s) {
        while (f < nums1.size() && s < nums2.size() && nums1.get(f) == nums2.get(s)) {
            f++;
            s++;
        }

        return s == nums2.size() || (f < nums1.size() && nums1.get(f) > nums2.get(s));
    }

    public int[] getMonotonic(int[] nums) {
        int[] monotonic = new int[nums.length];
        Arrays.fill(monotonic, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]) {
                monotonic[stack.pop()] = i;
            }
            stack.push(i);
        }

        return monotonic;
    }

    public List<Integer> getMaxSequence(int[] nums, int[] monotonic, int k) {
        List<Integer> maxSeq = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (maxSeq.size() == k) break;

            if (monotonic[i] == -1 || nums.length-monotonic[i] < k-maxSeq.size()) {
                maxSeq.add(nums[i]);
            }
        }

        return maxSeq;
    }
}