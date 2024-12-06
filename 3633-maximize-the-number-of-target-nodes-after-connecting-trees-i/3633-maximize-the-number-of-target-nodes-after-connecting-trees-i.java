class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] result = new int[edges1.length+1];
        if (k == 0) {
            Arrays.fill(result, 1);
            return result;
        }

        List<Integer>[] graph1 = buildGraph(edges1);
        List<Integer>[] graph2 = buildGraph(edges2);
        
        int maxDP2 = 1;
        for (int i = 0; i <= edges2.length; i++) {
            maxDP2 = Math.max(maxDP2, getTargets(graph2, -1, i, k-1));
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = getTargets(graph1, -1, i, k) + maxDP2;
        }
        return result;
    }

    public int getTargets(List<Integer>[] graph, int parent, int node, int k) {
        if (k < 0) return 0;

        int targets = 1;
        for (int child : graph[node]) {
            if (child == parent) continue;
            targets += getTargets(graph, node, child, k-1);
        }
        return targets;        
    }

    public List<Integer>[] buildGraph(int[][] edges) {
        List<Integer>[] graph = new ArrayList[edges.length+1];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) graph[edge[0]] = new ArrayList<>();
            if (graph[edge[1]] == null) graph[edge[1]] = new ArrayList<>();
            
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        return graph;
    }
}