class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 3 || n > 45) return result;

        boolean[] used = new boolean[10];
        backtrack(result, new ArrayList<>(), used, 0, n, k);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> curr, boolean[] used, int sum, int target, int k) {
        if (sum == target && curr.size() == k) {
            result.add(new ArrayList<>(curr));
        }
        if (curr.size() >= k) return;

        int start = (curr.size() > 0) ? curr.get(curr.size() - 1) : 1;
        for (int i = start; i <= 9; i++) {
            if (used[i]) continue;

            used[i] = true;
            curr.add(i);
            backtrack(result, curr, used, sum + i, target, k);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}