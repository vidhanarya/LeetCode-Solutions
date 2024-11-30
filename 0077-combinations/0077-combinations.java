class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, result, new ArrayList<>(), k, 1);
        return result;
    }

    public void backtrack(int n, List<List<Integer>> result, List<Integer> curr, int k, int i) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j <= n; j++) {
            curr.add(j);
            backtrack(n, result, curr, k, j+1);
            curr.remove(curr.size() - 1);
        }
    }
}