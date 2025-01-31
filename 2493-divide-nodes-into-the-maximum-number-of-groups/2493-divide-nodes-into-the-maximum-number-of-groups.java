class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            graph.get(edge[0]-1).add(edge[1]-1);
            graph.get(edge[1]-1).add(edge[0]-1);
        }

        if (!isBipartite(graph)) return -1;
        
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = getDiameter(graph, i);
        }

        return getTotalGroups(graph, distances);
    }

    public int getTotalGroups(List<List<Integer>> graph, int[] distances) {
        int totalGroups = 0;
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < graph.size(); i++) {
            if (visited[i]) continue;

            Queue<Integer> bfs = new LinkedList<>();
            bfs.offer(i);
            visited[i] = true;
            int currGroups = distances[i];

            while (!bfs.isEmpty()) {
                int parent = bfs.poll();
                currGroups = Math.max(currGroups, distances[parent]);

                for (int child: graph.get(parent)) {
                    if (visited[child]) continue;

                    bfs.offer(child);
                    visited[child] = true;
                }
            }

            totalGroups += currGroups;
        }

        return totalGroups;
    }

    public int getDiameter(List<List<Integer>> graph, int node) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(node);
        visited[node] = true;

        int diameter = 0;
        while (!bfs.isEmpty()) {
            int numNodes = bfs.size();

            for (int i = 0; i < numNodes; i++) {
                int parent = bfs.poll();
                for (int child: graph.get(parent)) {
                    if (visited[child]) continue;
                    
                    bfs.offer(child);
                    visited[child] = true;
                }
            }
            diameter++; 
        }

        return diameter;
    }

    public boolean isBipartite(List<List<Integer>> graph) {
        int[] colors = new int[graph.size()];
        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.size(); i++) {
            if (colors[i] != -1) continue;

            Queue<Integer> bfs = new LinkedList<>();
            bfs.offer(i);
            colors[i] = 0;
            while (!bfs.isEmpty()) {
                int node = bfs.poll();
                for (int child: graph.get(node)) {
                    if (colors[child] == colors[node]) return false;
                    if (colors[child] != -1) continue;

                    bfs.offer(child);
                    colors[child] = 1 - colors[node];
                }
            }
        }

        return true;
    }
}