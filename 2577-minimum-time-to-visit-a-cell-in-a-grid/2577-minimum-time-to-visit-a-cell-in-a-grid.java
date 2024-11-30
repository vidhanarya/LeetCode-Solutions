class State {
    int x;
    int y;
    int t;

    State(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int n = grid.length, m = grid[0].length;
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        PriorityQueue<State> bfs = new PriorityQueue<>(Comparator.comparingInt(a -> a.t));
        Set<String> visited = new HashSet<>();
        bfs.offer(new State(0, 0, 0));
        if (grid[0][1] <= 1) {
            bfs.offer(new State(0, 1, 1));
            visited.add(getEdge(0, 1));
        }
        if (grid[1][0] <= 1) {
            bfs.offer(new State(1, 0, 1));
            visited.add(getEdge(1, 0));
        }

        while (!bfs.isEmpty()) {
            State state = bfs.poll();
            if (state.x == n - 1 && state.y == m - 1) return state.t;

            for (int[] direction: directions) {
                int x = state.x + direction[0];
                int y = state.y + direction[1];

                if (!valid(n, m, x, y) || visited.contains(getEdge(x, y))) continue;
                bfs.offer(new State(x, y, Math.max(state.t + 1, grid[x][y] + 1 - (grid[x][y] - state.t) % 2)));
                visited.add(getEdge(x, y));
            }
        }

        return -1;
    }

    public boolean valid(int n, int m, int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }

    public String getEdge(int x, int y) {
        return x + ", " + y;
    }
}