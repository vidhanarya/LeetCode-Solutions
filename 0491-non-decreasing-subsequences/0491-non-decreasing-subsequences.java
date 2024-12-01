class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(result, new ArrayList<>(), 0, nums);
        return new ArrayList<>(result);
    }

    public void backtrack(Set<List<Integer>> result, List<Integer> curr, int i, int[] nums) {
        if (curr.size() >= 2) result.add(new ArrayList<>(curr));
        if (i >= nums.length) return;

        for (int j = i; j < nums.length; j++) {
            if (!curr.isEmpty() && nums[j] < curr.getLast()) continue;

            curr.add(nums[j]);
            backtrack(result, curr, j + 1, nums);
            curr.removeLast();
        }
    }
}