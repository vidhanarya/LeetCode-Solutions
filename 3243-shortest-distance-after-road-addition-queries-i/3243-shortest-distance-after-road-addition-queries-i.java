class Solution {
    int[] distances;
    List<List<Integer>> graph;

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph = new ArrayList<>();
        distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = (i < n-1) ? Integer.MAX_VALUE : 0;
            graph.add(new ArrayList<>());
        }

        for (int i = n-2; i >= 0; i--) {
            add(i, i+1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            add(queries[i][0], queries[i][1]);
            result[i] = distances[0];
        }

        return result;
    }

    public void add(int s, int e) {
        graph.get(e).add(s);

        if (distances[e] == Integer.MAX_VALUE) return;
        distances[s] = Math.min(distances[s], distances[e] + 1);

        Queue<Integer[]> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int parent: graph.get(s)) {
            bfs.offer(new Integer[]{parent, s});
            visited.add(parent);
        }

        while (!bfs.isEmpty()) {
            Integer[] state = bfs.poll();
            int p = state[0], c = state[1];
            if (distances[p] == Integer.MAX_VALUE) distances[p] = distances[c] + 1;
            else distances[p] = Math.min(distances[p], distances[c] + 1);

            for (int pp: graph.get(p)) {
                if (visited.contains(pp)) continue;
                visited.add(pp);
                bfs.add(new Integer[]{pp, p});
            }
        }
    }
}