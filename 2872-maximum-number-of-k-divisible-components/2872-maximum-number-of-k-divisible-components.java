class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n == 1) return 1;

        List<Integer>[] graph = new ArrayList[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList<>();
            if (graph[edge[1]] == null) graph[edge[1]] = new ArrayList<>();

            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        long[] result = dfs(graph, visited, values, k, 0);

        return (int) result[0];
    }

    public long[] dfs(List<Integer>[] graph, Set<Integer> visited, int[] values, int k, int i) {
        long[] result = new long[2];
        result[1] = values[i];

        for (int child : graph[i]) {
            if (visited.contains(child)) continue;

            visited.add(child);
            long[] temp = dfs(graph, visited, values, k, child);
            result[0] += temp[0];
            result[1] += temp[1];
        }

        if (result[1] % k == 0) {
            result[0]++;
            result[1] = 0;
        }

        return result;
    }
}