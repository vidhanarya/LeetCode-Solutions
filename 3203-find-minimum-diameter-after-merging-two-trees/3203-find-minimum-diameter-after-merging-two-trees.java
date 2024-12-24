class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int diameter1 = getDiameter(edges1);
        int diameter2 = getDiameter(edges2);
        int combinedDiameter = (int) Math.ceil(diameter1 / 2.0) + (int) Math.ceil(diameter2 / 2.0) + 1;

        return Math.max(combinedDiameter, Math.max(diameter1, diameter2));
    }

    public int getDiameter(int[][] edges) {
        if (edges.length <= 2) return edges.length;

        List<Integer>[] graph = new ArrayList[edges.length+1];
        for (int i = 0; i < edges.length; i++) {
            if (graph[edges[i][0]] == null) graph[edges[i][0]] = new ArrayList<>();
            if (graph[edges[i][1]] == null) graph[edges[i][1]] = new ArrayList<>();

            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        int farthestPoint = dfs(graph, new HashSet<>(List.of(0)), 0, 0, 0)[1];
        int diameter = dfs(graph, new HashSet<>(List.of(farthestPoint)), farthestPoint, 0, farthestPoint)[0];

        return diameter;
    }

    public int[] dfs(List<Integer>[] graph, Set<Integer> visited, int root, int currDepth, int currFarthest) {
        int depth = currDepth;
        int farthestPoint = currFarthest;

        for (int neighbour : graph[root]) {
            if (visited.contains(neighbour)) continue;
            
            visited.add(neighbour);
            int[] neighbourDepth = dfs(graph, visited, neighbour, currDepth+1, neighbour);
            if (neighbourDepth[0] < depth) continue;

            depth = neighbourDepth[0];
            farthestPoint = neighbourDepth[1];
        }

        return new int[]{depth, farthestPoint};
    }
}