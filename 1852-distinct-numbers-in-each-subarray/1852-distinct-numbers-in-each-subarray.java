class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int[] ans = new int[nums.length - k + 1];
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }

                left++;
            }

            if (right - left + 1 == k) {
                ans[left] = freq.size();
            }
        }

        return ans;
    }
}