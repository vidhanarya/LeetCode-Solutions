class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> curr, int i, int[] nums, int target) {
        if (target < 0) return;
        else if (target == 0) result.add(new ArrayList<>(curr));
        else {
            for (int j = i; j < nums.length; j++) {
                if (j > i && nums[j] == nums[j - 1]) continue;

                curr.add(nums[j]);
                backtrack(result, curr, j + 1, nums, target - nums[j]);
                curr.remove(curr.size() - 1);
            }
        }
    }
}