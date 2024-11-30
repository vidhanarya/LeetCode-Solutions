class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> curr, int currSum, int i) {
        if (currSum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (currSum > target || i >= candidates.length) return;
        
        curr.add(candidates[i]);
        backtrack(candidates, target, result, curr, currSum + candidates[i], i);
        curr.remove(curr.size() - 1);
        backtrack(candidates, target, result, curr, currSum, i + 1);
    }
}