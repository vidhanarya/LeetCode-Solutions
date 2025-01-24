class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] visited = new int[graph.length];
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, visited, i) == 1) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    public int dfs(int[][] graph, int[] visited, int node) {
        visited[node] = 2;
        for (int neighbour : graph[node]) {
            if (visited[neighbour] == 1) continue;
            if (visited[neighbour] == 2 || visited[neighbour] == -1 || dfs(graph, visited, neighbour) == -1) {
                visited[node] = -1;
                return -1;
            }
        }

        visited[node] = 1;
        return 1;
    }
}