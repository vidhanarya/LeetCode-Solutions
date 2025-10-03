class State {
    int i;
    int j;
    int m;

    State(int i, int j, int m) {
        this.i = i;
        this.j = j;
        this.m = m;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] neighbours = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<State> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isBoundary(n, m, i, j)) {
                    continue;
                }

                pq.add(new State(i, j, heightMap[i][j]));
                visited[i][j] = true;
            }
        }

        int trappedWater = 0;
        while (!pq.isEmpty()) {
            State state = pq.poll();
            int i = state.i, j = state.j;
            trappedWater += Math.max(0, state.m - heightMap[i][j]);
            
            for (int[] neighbour : neighbours) {
                int x = i + neighbour[0];
                int y = j + neighbour[1];

                if (!isValid(n, m, x, y) || visited[x][y]) {
                    continue;
                }

                visited[x][y] = true;
                pq.add(new State(x, y, Math.max(heightMap[x][y], state.m)));
            }
        }

        return trappedWater;
    }

    public boolean isValid(int n, int m, int i, int j) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public boolean isBoundary(int n, int m, int i, int j) {
        return (i == 0 || j == 0 || i == n-1 || j == m-1);
    }
}