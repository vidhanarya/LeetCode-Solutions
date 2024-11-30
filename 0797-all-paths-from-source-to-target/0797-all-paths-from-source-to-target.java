class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(graph, result, new ArrayList<Integer>(List.of(0)), new HashSet<Integer>(), 0);
        return result;
    }

    public void backtrack(int[][] graph, List<List<Integer>> result, List<Integer> curr, Set<Integer> visited, int s) {
        if (s == graph.length - 1) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int n: graph[s]) {
            if (visited.contains(n)) continue;

            visited.add(n);
            curr.add(n);
            backtrack(graph, result, curr, visited, n);
            curr.remove(curr.size() - 1);
            visited.remove(n);
        }
    }
}