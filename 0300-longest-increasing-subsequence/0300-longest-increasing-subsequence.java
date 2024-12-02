class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> seq = new ArrayList<>();
        seq.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > seq.get(seq.size() - 1)) seq.add(nums[i]);
            else {
                int j = binarySearch(seq, nums[i]);
                seq.set(j, nums[i]);
            }
        }

        return seq.size();
    }

    public int binarySearch(List<Integer> seq, int target) {
        int left = 0, right = seq.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (seq.get(mid) == target) return mid;
            else if (seq.get(mid) > target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}