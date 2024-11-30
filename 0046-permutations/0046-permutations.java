class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), new HashSet<>(), nums);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> curr, Set<Integer> visited, int[] nums) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int n: nums) {
            if (visited.contains(n)) continue;

            visited.add(n);
            curr.add(n);
            backtrack(result, curr, visited, nums);
            visited.remove(n);
            curr.remove(curr.size() - 1);
        }
    }
}