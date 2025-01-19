class State {
    int x;
    int y;
    int h;

    State(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<State> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
        for (int i = 0; i < m; i++) {
            bfs.add(new State(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            
            bfs.add(new State(i, n-1, heightMap[i][n-1]));
            visited[i][n-1] = true;

            if (i > 0 && i < m-1) continue;

            for (int j = 1; j < n-1; j++) {
                bfs.add(new State(i, j, heightMap[i][j]));
                visited[i][j] = true;
            }
        }

        int totalTrappedWater = 0;
        while (!bfs.isEmpty()) {
            State state = bfs.poll();
            totalTrappedWater += state.h - heightMap[state.x][state.y];

            for (int[] direction: directions) {
                int x = state.x + direction[0];
                int y = state.y + direction[1];

                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                bfs.add(new State(x, y, Math.max(heightMap[x][y], state.h)));
                visited[x][y] = true;
            }
        }

        return totalTrappedWater;
    }
}