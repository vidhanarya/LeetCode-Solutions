class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> curr, int i) {
        if (i > nums.length) return;

        result.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(nums, result, curr, j+1);
            curr.remove(curr.size() - 1);
        }
    }
}